package br.com.amartins.springarchitecture.course.application.exception

class CourseNotSavedException(message: String?, cause: Throwable?) : RuntimeException(message, cause) {
    constructor(message: String?) : this(message, null)
}
