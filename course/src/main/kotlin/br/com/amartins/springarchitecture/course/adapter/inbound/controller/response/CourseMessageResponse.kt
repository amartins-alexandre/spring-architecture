package br.com.amartins.springarchitecture.course.adapter.inbound.controller.response

data class CourseMessageResponse(
    val message: String,
    val error: Boolean = false
)
