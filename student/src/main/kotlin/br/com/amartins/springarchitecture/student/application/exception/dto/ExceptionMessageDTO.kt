package br.com.amartins.springarchitecture.student.application.exception.dto

data class ExceptionMessageDTO(
    val message: String?,
    val cause: Throwable?
)
