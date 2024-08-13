package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.InactivateEnrollmentUseCase
import org.springframework.stereotype.Service

@Service
class InactivateEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository
) : InactivateEnrollmentUseCase {
    override fun execute(externalId: String) {
        val enrollment =
            gatewayRepository.findOneByExternalId(externalId)
            .copy(active = false)
        gatewayRepository.upsertCourse(enrollment)
    }
}
