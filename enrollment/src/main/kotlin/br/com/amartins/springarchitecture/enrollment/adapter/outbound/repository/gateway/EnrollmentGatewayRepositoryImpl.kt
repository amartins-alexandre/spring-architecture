package br.com.amartins.springarchitecture.enrollment.adapter.outbound.repository.gateway

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.repository.EnrollmentRepository
import br.com.amartins.springarchitecture.enrollment.adapter.outbound.repository.entities.EnrollmentEntity
import br.com.amartins.springarchitecture.enrollment.application.constants.Message
import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import br.com.amartins.springarchitecture.enrollment.application.exception.DataAlreadyExistsException
import br.com.amartins.springarchitecture.enrollment.application.exception.DataNotFoundException
import br.com.amartins.springarchitecture.enrollment.application.exception.EnrollmentNotSavedException
import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Component

@Component
class EnrollmentGatewayRepositoryImpl(
    private val repository: EnrollmentRepository
) : EnrollmentGatewayRepository {
    override fun findOne(id: String): Enrollment {
        val entityOptional = repository.findByIdAndActiveIsTrue(id)
        if (!entityOptional.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_COURSE)
        }

        return entityOptional.get().toDomain()
    }

    override fun findAll(): List<Enrollment> {
        val enrollmentEntities = repository.findAllByActiveIsTrue()
        if (!enrollmentEntities.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_COURSE)
        }
        return enrollmentEntities.get().map { it.toDomain() }
    }

    override fun upsertCourse(enrollment: Enrollment): Enrollment =
        try {
            repository.save(EnrollmentEntity.fromDomain(enrollment)).toDomain()
        } catch (ex: DataIntegrityViolationException) {
            throw DataAlreadyExistsException(Message.ENROLLMENT_ALREADY_EXISTS)
        } catch (ex: Exception) {
            throw EnrollmentNotSavedException(Message.UNEXPECTED_ERROR_SAVED)
        }
}
