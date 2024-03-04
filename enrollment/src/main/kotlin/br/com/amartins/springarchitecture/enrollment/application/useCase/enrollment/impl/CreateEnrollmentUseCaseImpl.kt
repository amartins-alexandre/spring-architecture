package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.CreateEnrollmentUseCase
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.UUID

@Service
class CreateEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository,
) : CreateEnrollmentUseCase {
    override fun execute(enrollment: Enrollment) {
        gatewayRepository.upsertCourse(enrollment)
    }

    private fun generateEnrollmentCode(courseCode: String): String {
        val today =
            LocalDate.now(ZoneId.of("America/Sao_Paulo"))
                .format(DateTimeFormatter.ofPattern("yyyyMM"))

        UUID.randomUUID().timestamp()
        return "$today$courseCode"
    }
}
