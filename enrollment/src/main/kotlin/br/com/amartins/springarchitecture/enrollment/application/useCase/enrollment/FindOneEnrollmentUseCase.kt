package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment

interface FindOneEnrollmentUseCase {
    fun execute(externalId: String): Map<String, Any>
}
