package br.com.amartins.springarchitecture.course.application.config

import br.com.amartins.springarchitecture.course.application.exception.DataAlreadyExistsException
import br.com.amartins.springarchitecture.course.application.exception.DataNotFoundException
import br.com.amartins.springarchitecture.course.application.exception.CourseNotSavedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomExceptionHandler {
    @ExceptionHandler(value = [ DataAlreadyExistsException::class ])
    fun handleDataAlreadyExistsException(exception: DataAlreadyExistsException) =
        ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.message)

    @ExceptionHandler(value = [ DataNotFoundException::class ])
    fun handleDataNotFoundException(exception: DataNotFoundException) =
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.message)

    @ExceptionHandler(value = [ CourseNotSavedException::class ])
    fun handleException(exception: CourseNotSavedException) =
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.message)

    @ExceptionHandler(value = [ Exception::class ])
    fun handleException(exception: Exception) =
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.message)
}
