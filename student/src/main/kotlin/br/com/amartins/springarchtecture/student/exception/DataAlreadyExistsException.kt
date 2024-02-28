package br.com.amartins.springarchtecture.student.exception

class DataAlreadyExistsException(message: String?, cause: Throwable?) : RuntimeException(message, cause) {
    constructor(message: String?) : this(message, null)
}
