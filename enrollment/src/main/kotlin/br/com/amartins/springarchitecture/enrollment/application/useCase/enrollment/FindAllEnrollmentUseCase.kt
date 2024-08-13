package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment

interface FindAllEnrollmentUseCase {
    fun execute(): List<Map<String, Any>>
}
