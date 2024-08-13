package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.CreateEnrollmentUseCase
import org.springframework.stereotype.Service

@Service
class CreateEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository,
) : CreateEnrollmentUseCase {
    override fun execute(enrollment: Enrollment) {
        gatewayRepository.upsertCourse(enrollment)
    }
}
