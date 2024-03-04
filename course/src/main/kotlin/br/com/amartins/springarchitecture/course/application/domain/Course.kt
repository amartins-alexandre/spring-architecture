package br.com.amartins.springarchitecture.course.application.domain

import br.com.amartins.springarchitecture.course.application.domain.enums.CourseType

data class Course(
    val id: String? = null,
    val externalId: String? = null,
    val name: String,
    val type: CourseType = CourseType.FREEDOM,
    val active: Boolean = true,
)
