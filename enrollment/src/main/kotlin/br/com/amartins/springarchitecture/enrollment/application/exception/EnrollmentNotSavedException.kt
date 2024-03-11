package br.com.amartins.springarchitecture.enrollment.application.exception

class EnrollmentNotSavedException(message: String?, cause: Throwable?) : RuntimeException(message, cause) {
    constructor(message: String?) : this(message, null)
}