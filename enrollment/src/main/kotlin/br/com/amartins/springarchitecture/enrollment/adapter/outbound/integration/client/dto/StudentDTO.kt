package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto

import br.com.amartins.springarchitecture.enrollment.application.domain.Student

data class StudentDTO(
    val id: String,
    val name: String,
    val document: String
) {
    fun toDomain() =
        Student(
            id = this.id,
            name = this.name,
            document = this.document,
        )
}
