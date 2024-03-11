package br.com.amartins.springarchitecture.student.application.usecase

import br.com.amartins.springarchitecture.student.application.domain.Student

interface FindAllStudentsUseCase {
    fun execute(): List<Student>
}
