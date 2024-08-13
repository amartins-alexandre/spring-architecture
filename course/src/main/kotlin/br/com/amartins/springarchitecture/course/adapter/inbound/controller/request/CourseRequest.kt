package br.com.amartins.springarchitecture.course.adapter.inbound.controller.request

import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.domain.enums.CourseType

data class CourseRequest(
    val name: String,
    val type: CourseType,
) {
    fun toDomain(): Course =
        Course(
            name = this.name,
            type = this.type,
        )
}
