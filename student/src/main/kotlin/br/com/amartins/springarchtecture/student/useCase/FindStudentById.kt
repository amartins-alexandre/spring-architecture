package br.com.amartins.springarchtecture.student.useCase

import br.com.amartins.springarchtecture.student.domain.Student

interface FindStudentById {
    fun execute(id: String): Student?
}
