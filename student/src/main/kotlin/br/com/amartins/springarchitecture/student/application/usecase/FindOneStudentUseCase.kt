package br.com.amartins.springarchitecture.student.application.usecase

import br.com.amartins.springarchitecture.student.application.domain.Student

interface FindOneStudentUseCase {
    fun execute(externalId: String): Student
}
