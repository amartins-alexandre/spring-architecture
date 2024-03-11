package br.com.amartins.springarchitecture.student.adapter.outbound.repository.gateway

import br.com.amartins.springarchitecture.student.adapter.outbound.repository.StudentRepository
import br.com.amartins.springarchitecture.student.adapter.outbound.repository.entity.StudentEntity
import br.com.amartins.springarchitecture.student.application.constants.Message
import br.com.amartins.springarchitecture.student.application.domain.Student
import br.com.amartins.springarchitecture.student.application.exception.DataAlreadyExistsException
import br.com.amartins.springarchitecture.student.application.exception.DataNotFoundException
import br.com.amartins.springarchitecture.student.application.exception.StudentNotSavedException
import br.com.amartins.springarchitecture.student.application.gateway.repository.StudentGatewayRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Component

@Component
class StudentGatewayRepositoryImpl(
    private val repository: StudentRepository
) : StudentGatewayRepository {
    override fun findByExternalId(externalId: String): Student {
        val entityOptional = repository.findByExternalIdAndActiveIsTrue(externalId)
        if (!entityOptional.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_STUDENT)
        }

        return entityOptional.get().toDomain()
    }

    override fun findAllStudents(): List<Student> {
        val studentEntities = repository.findAllByActiveIsTrue()
        if (!studentEntities.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_STUDENT)
        }

        return studentEntities.get().map { it.toDomain() }
    }

    override fun upsertStudent(student: Student): Student =
        try {
           repository.save(
               StudentEntity.fromDomain(student)
           ).toDomain()
        } catch (ex: DataIntegrityViolationException) {
           throw DataAlreadyExistsException(Message.STUDENT_ALREADY_EXISTS_DOCUMENT.replace("{}", student.document))
        } catch (ex: RuntimeException) {
            println(ex)
            throw StudentNotSavedException(Message.UNEXPECTED_ERROR)
        }
}
