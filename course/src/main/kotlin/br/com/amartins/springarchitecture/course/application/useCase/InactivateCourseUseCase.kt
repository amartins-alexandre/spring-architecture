package br.com.amartins.springarchitecture.course.application.useCase

interface InactivateCourseUseCase {
    fun execute(externalId: String): String
}
