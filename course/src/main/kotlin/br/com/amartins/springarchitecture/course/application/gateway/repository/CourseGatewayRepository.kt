package br.com.amartins.springarchitecture.course.application.gateway.repository

import br.com.amartins.springarchitecture.course.application.domain.Course

interface CourseGatewayRepository {
    fun findByExternalId(externalId: String): Course

    fun findAll(): List<Course>

    fun upsertCourse(course: Course): Course
}
