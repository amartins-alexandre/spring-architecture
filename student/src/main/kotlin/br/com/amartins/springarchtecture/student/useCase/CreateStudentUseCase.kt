package br.com.amartins.springarchtecture.student.useCase

import br.com.amartins.springarchtecture.student.domain.Student

interface CreateStudentUseCase {
    fun execute(student: Student): Student
}
