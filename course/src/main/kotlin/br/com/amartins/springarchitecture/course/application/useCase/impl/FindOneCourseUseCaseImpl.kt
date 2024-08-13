package br.com.amartins.springarchitecture.course.application.useCase.impl

import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.gateway.repository.CourseGatewayRepository
import br.com.amartins.springarchitecture.course.application.useCase.FindOneCourseUseCase
import org.springframework.stereotype.Service

@Service
class FindOneCourseUseCaseImpl(
    private val gatewayRepository: CourseGatewayRepository,
) : FindOneCourseUseCase {
    override fun execute(code: String): Course = gatewayRepository.findByExternalId(code)
}
