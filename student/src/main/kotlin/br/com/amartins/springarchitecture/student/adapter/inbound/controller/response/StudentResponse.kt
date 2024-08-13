package br.com.amartins.springarchitecture.student.adapter.inbound.controller.response

import br.com.amartins.springarchitecture.student.application.domain.Student
import com.fasterxml.jackson.annotation.JsonProperty

data class StudentResponse(
    @JsonProperty(value = "external_id") val externalId: String,
    val name: String,
    val document: String
) {
    companion object {
        fun fromDomain(student: Student): StudentResponse =
            StudentResponse(
                externalId = student.externalId!!,
                name = student.name,
                document = student.document
            )
    }
}
