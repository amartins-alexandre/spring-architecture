package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.gateway.integration.CourseGatewayIntegration
import br.com.amartins.springarchitecture.enrollment.application.gateway.integration.StudentGatewayIntegration
import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.FindOneEnrollmentUseCase
import org.springframework.stereotype.Service

@Service
class FindOneEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository,
    private val studentIntegration: StudentGatewayIntegration,
    private val courseIntegration: CourseGatewayIntegration
) : FindOneEnrollmentUseCase {
    override fun execute(externalId: String): Map<String, Any> {
        val enrollment = gatewayRepository.findOneByExternalId(externalId)
        val student = studentIntegration.getByExternalId(enrollment.studentExternalId)
        val course = courseIntegration.getByExternalId(enrollment.courseExternalId)
        return mutableMapOf(
            "enrollment" to enrollment,
            "student" to student,
            "course" to course
        )
    }
}
