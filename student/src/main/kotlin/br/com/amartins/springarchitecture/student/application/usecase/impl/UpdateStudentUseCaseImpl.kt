package br.com.amartins.springarchitecture.student.application.usecase.impl

import br.com.amartins.springarchitecture.student.application.domain.Student
import br.com.amartins.springarchitecture.student.application.gateway.repository.StudentGatewayRepository
import br.com.amartins.springarchitecture.student.application.usecase.UpdateStudentUseCase
import org.springframework.stereotype.Service

@Service
class UpdateStudentUseCaseImpl(
    private val gatewayRepository: StudentGatewayRepository
) : UpdateStudentUseCase {
    override fun execute(student: Student) {
        val foundStudent = gatewayRepository.findByExternalId(student.externalId!!)
        gatewayRepository.upsertStudent(
            student =
            student.copy(
                id = foundStudent.id,
                document = foundStudent.document
            )
        )
    }
}
