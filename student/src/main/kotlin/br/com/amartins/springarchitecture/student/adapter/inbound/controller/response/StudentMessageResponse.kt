package br.com.amartins.springarchitecture.student.adapter.inbound.controller.response

data class StudentMessageResponse(
    val message: String,
    val error: Boolean = false
)
