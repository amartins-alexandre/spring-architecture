package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto

import br.com.amartins.springarchitecture.enrollment.application.domain.Student
import com.fasterxml.jackson.annotation.JsonProperty

data class StudentDTO(
    @JsonProperty("external_id") val externalId: String,
    val name: String,
    val document: String
) {
    fun toDomain() =
        Student(
            externalId = this.externalId,
            name = this.name,
            document = this.document,
        )
}
