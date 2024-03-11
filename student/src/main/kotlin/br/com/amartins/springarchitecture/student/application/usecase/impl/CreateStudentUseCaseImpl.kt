package br.com.amartins.springarchitecture.student.application.usecase.impl

import br.com.amartins.springarchitecture.student.application.domain.Student
import br.com.amartins.springarchitecture.student.application.gateway.repository.StudentGatewayRepository
import br.com.amartins.springarchitecture.student.application.usecase.CreateStudentUseCase
import org.springframework.stereotype.Service

@Service
class CreateStudentUseCaseImpl(
    private val gatewayRepository: StudentGatewayRepository,
) : CreateStudentUseCase {
    override fun execute(student: Student) {
        gatewayRepository.upsertStudent(student)
    }
}
