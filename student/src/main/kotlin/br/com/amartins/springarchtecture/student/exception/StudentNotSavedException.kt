package br.com.amartins.springarchtecture.student.exception

class StudentNotSavedException(message: String?, cause: Throwable?) : RuntimeException(message, cause) {
    constructor(message: String?) : this(message, null)
}
