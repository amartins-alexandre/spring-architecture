package br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment

interface CreateEnrollmentUseCase {
    fun execute(enrollment: Enrollment)
}
