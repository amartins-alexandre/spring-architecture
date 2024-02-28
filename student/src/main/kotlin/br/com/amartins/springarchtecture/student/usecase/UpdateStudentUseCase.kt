package br.com.amartins.springarchtecture.student.usecase

import br.com.amartins.springarchtecture.student.domain.Student

interface UpdateStudentUseCase {
    fun execute(student: Student): Student
}
