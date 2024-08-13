package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.UpdateEnrollmentUseCase
import org.springframework.stereotype.Service

@Service
class UpdateEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository
) : UpdateEnrollmentUseCase {
    override fun execute(enrollment: Enrollment) {
        val enrollmentFound = gatewayRepository.findOneByExternalId(enrollment.externalId!!)
        gatewayRepository.upsertCourse(enrollment.copy(id = enrollmentFound.id))
    }
}
