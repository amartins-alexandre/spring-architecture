package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment

interface InactivateEnrollmentUseCase {
    fun execute(id: String)
}
