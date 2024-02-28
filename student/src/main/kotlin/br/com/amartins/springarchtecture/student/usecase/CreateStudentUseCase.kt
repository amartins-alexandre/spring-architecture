package br.com.amartins.springarchtecture.student.usecase

import br.com.amartins.springarchtecture.student.domain.Student

interface CreateStudentUseCase {
    fun execute(student: Student): Boolean
}
