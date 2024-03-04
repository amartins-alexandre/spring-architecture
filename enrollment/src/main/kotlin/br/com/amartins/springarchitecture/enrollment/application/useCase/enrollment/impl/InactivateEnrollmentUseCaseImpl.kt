package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.InactivateEnrollmentUseCase
import org.springframework.stereotype.Service

@Service
class InactivateEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository
) : InactivateEnrollmentUseCase {
    override fun execute(id: String) {
        val course = gatewayRepository.findOne(id).copy(active = false)
        gatewayRepository.upsertCourse(course)
    }
}
