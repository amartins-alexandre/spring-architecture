package br.com.amartins.springarchitecture.enrollment.adapter.inbound.controller.request

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment

data class EnrollmentRequest(
    val studentExternalId: String,
    val courseExternalId: String,
) {
    fun toDomain(): Enrollment =
        Enrollment(
            studentExternalId = this.studentExternalId,
            courseExternalId = this.courseExternalId,
        )
}
