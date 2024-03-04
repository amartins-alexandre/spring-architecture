package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.FindAllEnrollmentUseCase
import org.springframework.stereotype.Service

@Service
class FindAllEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository,
) : FindAllEnrollmentUseCase {
    override fun execute(): List<Enrollment> = gatewayRepository.findAll()
}
