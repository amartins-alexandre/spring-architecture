package br.com.amartins.springarchitecture.student.application.exception

class StudentNotSavedException(message: String?, cause: Throwable?) : RuntimeException(message, cause) {
    constructor(message: String?) : this(message, null)
}
