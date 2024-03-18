package br.com.amartins.springarchitecture.enrollment.application.gateway.repository

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment

interface EnrollmentGatewayRepository {
    fun findOneByExternalId(externalId: String): Enrollment

    fun findAll(): List<Enrollment>

    fun upsertCourse(enrollment: Enrollment): Enrollment
}
