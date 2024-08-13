package br.com.amartins.springarchitecture.course.adapter.inbound.controller.response

import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.domain.enums.CourseType
import com.fasterxml.jackson.annotation.JsonProperty

data class CourseResponse(
    @JsonProperty(value = "external_id") val externalId: String,
    val name: String,
    val type: CourseType,
) {
    companion object {
        fun fromDomain(course: Course): CourseResponse =
            CourseResponse(
                externalId = course.externalId!!,
                name = course.name,
                type = course.type,
            )
    }
}
