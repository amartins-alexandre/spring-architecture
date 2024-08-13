package br.com.amartins.springarchitecture.student.application.usecase

interface InactivateStudentUseCase {
    fun execute(externalId: String): String
}
