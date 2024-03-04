package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment

interface FindAllEnrollmentUseCase {
    fun execute(): List<Enrollment>
}
