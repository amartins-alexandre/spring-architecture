package br.com.amartins.springarchitecture.student.application.usecase.impl

import br.com.amartins.springarchitecture.student.application.constants.Message
import br.com.amartins.springarchitecture.student.application.exception.DataNotFoundException
import br.com.amartins.springarchitecture.student.application.gateway.repository.StudentGatewayRepository
import br.com.amartins.springarchitecture.student.application.usecase.InactivateStudentUseCase
import org.springframework.stereotype.Service

@Service
class InactivateStudentUseCaseImp(
    private val gatewayRepository: StudentGatewayRepository
) : InactivateStudentUseCase {
    override fun execute(externalId: String): String =
        try {
            val student = gatewayRepository.findByExternalId(externalId).copy(active = false)
            gatewayRepository.upsertStudent(student)
            Message.STUDENT_INACTIVATED
        } catch (ex: DataNotFoundException) {
            Message.STUDENT_ALREADY_INACTIVATED
        }.replace("{}", externalId)
}
