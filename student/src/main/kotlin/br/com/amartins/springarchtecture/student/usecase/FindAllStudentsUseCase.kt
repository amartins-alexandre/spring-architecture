package br.com.amartins.springarchtecture.student.usecase

import br.com.amartins.springarchtecture.student.domain.Student

interface FindAllStudentsUseCase {
    fun execute(): List<Student>
}
