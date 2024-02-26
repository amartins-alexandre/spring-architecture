package br.com.amartins.springarchtecture.student.domain

import br.com.amartins.springarchtecture.student.controller.dto.response.StudentResponse
import br.com.amartins.springarchtecture.student.repository.entity.StudentEntity
import java.util.UUID

data class Student(
    val id: String?,
    val name: String,
    val document: String
) {
    private fun newStudent(maxLen: Int = 21): String =
        UUID.randomUUID()
            .toString()
            .replace("-", "")
            .substring(0, maxLen)

    fun toEntity(): StudentEntity =
        StudentEntity(
        id = this.id ?: this.newStudent(),
        name = this.name,
        document = this.document
    )

    fun toResponse(): StudentResponse =
        StudentResponse(
        id = this.id ?: "",
        name = this.name,
        document = this.document
    )
}
