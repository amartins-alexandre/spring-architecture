package br.com.amartins.springarchitecture.student.application.gateway.repository

import br.com.amartins.springarchitecture.student.application.domain.Student

interface StudentGatewayRepository {
    fun findByExternalId(externalId: String): Student

    fun findAllStudents(): List<Student>

    fun upsertStudent(student: Student): Student
}
