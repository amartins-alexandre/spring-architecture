package br.com.amartins.springarchitecture.course.adapter.outbound.repository.gateway

import br.com.amartins.springarchitecture.course.adapter.outbound.repository.CourseRepository
import br.com.amartins.springarchitecture.course.adapter.outbound.repository.entities.CourseEntity
import br.com.amartins.springarchitecture.course.application.constants.Message
import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.exception.CourseNotSavedException
import br.com.amartins.springarchitecture.course.application.exception.DataAlreadyExistsException
import br.com.amartins.springarchitecture.course.application.exception.DataNotFoundException
import br.com.amartins.springarchitecture.course.application.gateway.repository.CourseGatewayRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Component

@Component
class CourseGatewayRepositoryImpl(
    private val repository: CourseRepository
) : CourseGatewayRepository {
    override fun findByExternalId(externalId: String): Course {
        val entityOptional = repository.findByExternalIdAndActiveIsTrue(externalId)
        if (!entityOptional.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_COURSE)
        }

        return entityOptional.get().toDomain()
    }

    override fun findAll(): List<Course> {
        val coursesOptional = repository.findAllByActiveIsTrue()
        if (!coursesOptional.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_COURSE)
        }
        return coursesOptional.get().map { it.toDomain() }
    }

    override fun upsertCourse(course: Course): Course =
        try {
            repository.save(CourseEntity.fromDomain(course)).toDomain()
        } catch (ex: DataIntegrityViolationException) {
            throw DataAlreadyExistsException(Message.COURSE_ALREADY_EXISTS.replace("{}", course.name))
        } catch (ex: RuntimeException) {
            throw CourseNotSavedException(Message.UNEXPECTED_ERROR)
        }
}
