package br.com.amartins.springarchitecture.enrollment.application.gateway.integration

import br.com.amartins.springarchitecture.enrollment.application.domain.Course

interface CourseGatewayIntegration {
    fun getById(courseId: String): Course
}
