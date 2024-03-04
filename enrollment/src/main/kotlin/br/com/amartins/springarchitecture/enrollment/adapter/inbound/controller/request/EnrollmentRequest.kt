package br.com.amartins.springarchitecture.enrollment.adapter.inbound.controller.request

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment

data class EnrollmentRequest(
    val studentId: String,
    val courseCode: String,
) {
    fun toDomain(): Enrollment =
        Enrollment(
            studentId = this.studentId,
            courseCode = this.courseCode,
        )
}
