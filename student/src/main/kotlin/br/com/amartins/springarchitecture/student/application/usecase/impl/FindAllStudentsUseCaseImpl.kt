package br.com.amartins.springarchitecture.student.application.usecase.impl

import br.com.amartins.springarchitecture.student.application.domain.Student
import br.com.amartins.springarchitecture.student.application.gateway.repository.StudentGatewayRepository
import br.com.amartins.springarchitecture.student.application.usecase.FindAllStudentsUseCase
import org.springframework.stereotype.Service

@Service
class FindAllStudentsUseCaseImpl(
    private val gatewayRepository: StudentGatewayRepository
) : FindAllStudentsUseCase {
    override fun execute(): List<Student> = gatewayRepository.findAllStudents()
}
