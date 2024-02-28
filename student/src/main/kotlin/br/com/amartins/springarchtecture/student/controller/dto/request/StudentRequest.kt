package br.com.amartins.springarchtecture.student.controller.dto.request

import br.com.amartins.springarchtecture.student.domain.Student
import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect
data class StudentRequest(
    val name: String,
    val document: String
) {
    fun toDomain(): Student =
        Student(
        id = null,
        name = this.name,
        document = this.document
    )
}
