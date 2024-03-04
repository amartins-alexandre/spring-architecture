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
    override fun execute(id: String): Map<String, Any> {
        val enrollment = gatewayRepository.findOne(id)
        val student = studentIntegration.getById(enrollment.studentId)
        val course = courseIntegration.getById(enrollment.courseId)
        return mutableMapOf(
            "enrollment" to enrollment,
            "student" to student,
            "course" to course
        )
    }
}
