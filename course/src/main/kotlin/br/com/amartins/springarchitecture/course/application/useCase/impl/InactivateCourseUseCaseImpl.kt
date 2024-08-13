package br.com.amartins.springarchitecture.course.application.useCase.impl

import br.com.amartins.springarchitecture.course.application.constants.Message
import br.com.amartins.springarchitecture.course.application.exception.DataNotFoundException
import br.com.amartins.springarchitecture.course.application.useCase.InactivateCourseUseCase
import org.springframework.stereotype.Service

@Service
class InactivateCourseUseCaseImpl(
    private val gatewayRepository:
    br.com.amartins.springarchitecture.course.application.gateway.repository.CourseGatewayRepository
) : InactivateCourseUseCase {
    override fun execute(externalId: String): String =
        try {
            val course = gatewayRepository.findByExternalId(externalId).copy(active = false)
            gatewayRepository.upsertCourse(course)
            Message.COURSE_INACTIVATED
        } catch (ex: DataNotFoundException) {
            Message.COURSE_ALREADY_INACTIVATED
        }.replace("{}", externalId)
}
