package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment

interface FindOneEnrollmentUseCase {
    fun execute(id: String): Map<String, Any>
}
