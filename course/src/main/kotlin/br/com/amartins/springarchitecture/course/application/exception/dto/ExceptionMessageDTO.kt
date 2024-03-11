package br.com.amartins.springarchitecture.course.application.exception.dto

data class ExceptionMessageDTO(
    val message: String?,
    val cause: Throwable?
)
