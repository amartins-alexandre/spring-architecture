package br.com.amartins.springarchtecture.student.useCase

import br.com.amartins.springarchtecture.student.domain.Student

interface FindStudentByIdUseCase {
    fun execute(id: String): Student?
}
