package br.com.amartins.springarchitecture.course.application.useCase.impl

import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.gateway.repository.CourseGatewayRepository
import br.com.amartins.springarchitecture.course.application.useCase.UpdateCourseUseCase
import org.springframework.stereotype.Service

@Service
class UpdateCourseUseCaseImpl(
    private val gatewayRepository: CourseGatewayRepository
) : UpdateCourseUseCase {
    override fun execute(course: Course) {
        val courseFound = gatewayRepository.findByExternalId(course.externalId!!)
        gatewayRepository.upsertCourse(course.copy(id = courseFound.id))
    }
}
