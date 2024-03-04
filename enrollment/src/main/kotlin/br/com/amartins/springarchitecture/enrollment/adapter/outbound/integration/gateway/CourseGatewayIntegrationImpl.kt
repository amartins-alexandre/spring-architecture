package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.gateway

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.CourseServiceClient
import br.com.amartins.springarchitecture.enrollment.application.domain.Course
import br.com.amartins.springarchitecture.enrollment.application.gateway.integration.CourseGatewayIntegration
import org.springframework.stereotype.Component

@Component
class CourseGatewayIntegrationImpl(
    private val courseServiceClient: CourseServiceClient
) : CourseGatewayIntegration {
    override fun getById(courseId: String): Course {
        return courseServiceClient.getCourseById(courseId).toDomain()
    }
}
