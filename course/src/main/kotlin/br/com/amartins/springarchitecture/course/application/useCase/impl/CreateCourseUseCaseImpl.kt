package br.com.amartins.springarchitecture.course.application.useCase.impl

import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.gateway.repository.CourseGatewayRepository
import br.com.amartins.springarchitecture.course.application.useCase.CreateCourseUseCase
import org.springframework.stereotype.Service

@Service
class CreateCourseUseCaseImpl(
    private val gatewayRepository: CourseGatewayRepository,
) : CreateCourseUseCase {
    override fun execute(course: Course) {
        gatewayRepository.upsertCourse(course)
    }
}
