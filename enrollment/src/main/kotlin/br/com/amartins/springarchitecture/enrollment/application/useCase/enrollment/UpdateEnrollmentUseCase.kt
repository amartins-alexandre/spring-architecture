package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment

interface UpdateEnrollmentUseCase {
    fun execute(enrollment: Enrollment)
}
