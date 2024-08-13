package br.com.amartins.springarchitecture.course.application.useCase.impl

import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.gateway.repository.CourseGatewayRepository
import br.com.amartins.springarchitecture.course.application.useCase.FindAllCourseUseCase
import org.springframework.stereotype.Service

@Service
class FindAllCourseUseCaseImpl(
    private val gatewayRepository:
    br.com.amartins.springarchitecture.course.application.gateway.repository.CourseGatewayRepository,
) : FindAllCourseUseCase {
    override fun execute(): List<Course> = gatewayRepository.findAll()
}
