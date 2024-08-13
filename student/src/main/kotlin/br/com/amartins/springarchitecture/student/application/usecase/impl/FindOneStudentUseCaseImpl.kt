package br.com.amartins.springarchitecture.student.application.usecase.impl

import br.com.amartins.springarchitecture.student.application.domain.Student
import br.com.amartins.springarchitecture.student.application.gateway.repository.StudentGatewayRepository
import br.com.amartins.springarchitecture.student.application.usecase.FindOneStudentUseCase
import org.springframework.stereotype.Service

@Service
class FindOneStudentUseCaseImpl(
    private val gatewayRepository: StudentGatewayRepository
) : FindOneStudentUseCase {
    override fun execute(externalId: String): Student = gatewayRepository.findByExternalId(externalId = externalId)
}
