package br.com.amartins.springarchitecture.enrollment.application.gateway.integration

import br.com.amartins.springarchitecture.enrollment.application.domain.Student

interface StudentGatewayIntegration {
    fun getById(studentId: String): Student
}
