package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto

import br.com.amartins.springarchitecture.enrollment.application.domain.Course
import com.fasterxml.jackson.annotation.JsonProperty

data class CourseDTO(
    @JsonProperty("external_id") val externalId: String,
    val name: String,
    val type: String,
) {
    fun toDomain() =
        Course(
            externalId = this.externalId,
            name = this.name,
            type = this.type,
        )
}
