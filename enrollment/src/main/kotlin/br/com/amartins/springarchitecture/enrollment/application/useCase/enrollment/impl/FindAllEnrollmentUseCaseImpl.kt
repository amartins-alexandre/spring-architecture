package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.impl

import br.com.amartins.springarchitecture.enrollment.application.gateway.integration.CourseGatewayIntegration
import br.com.amartins.springarchitecture.enrollment.application.gateway.integration.StudentGatewayIntegration
import br.com.amartins.springarchitecture.enrollment.application.gateway.repository.EnrollmentGatewayRepository
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.FindAllEnrollmentUseCase
import org.springframework.stereotype.Service

@Service
class FindAllEnrollmentUseCaseImpl(
    private val gatewayRepository: EnrollmentGatewayRepository,
    private val studentIntegration: StudentGatewayIntegration,
    private val courseIntegration: CourseGatewayIntegration
) : FindAllEnrollmentUseCase {
    override fun execute(): List<Map<String, Any>> {
        val allEnrollments = ArrayList<Map<String, Any>>()
        gatewayRepository.findAll()
                .forEach {
                val student = studentIntegration.getByExternalId(it.studentExternalId)
                val course = courseIntegration.getByExternalId(it.courseExternalId)
                allEnrollments.add(
                    mutableMapOf(
                    "enrollment" to it,
                    "student" to student,
                    "course" to course
                )
                        )
            }

        return allEnrollments
    }
}
