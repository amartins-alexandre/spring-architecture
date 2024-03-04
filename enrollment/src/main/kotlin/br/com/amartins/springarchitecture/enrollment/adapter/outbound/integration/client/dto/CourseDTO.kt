package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto

import br.com.amartins.springarchitecture.enrollment.application.domain.Course

data class CourseDTO(
    val id: String?,
    val name: String,
    val code: String,
    val type: String,
) {
    fun toDomain() =
        Course(
            id = this.id,
            name = this.name,
            code = this.code,
            type = this.type,
        )
}
