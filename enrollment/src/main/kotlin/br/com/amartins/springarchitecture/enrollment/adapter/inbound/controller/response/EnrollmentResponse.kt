package br.com.amartins.springarchitecture.enrollment.adapter.inbound.controller.response

import br.com.amartins.springarchitecture.enrollment.application.domain.Course
import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import br.com.amartins.springarchitecture.enrollment.application.domain.Student

data class EnrollmentResponse(
    val code: String,
    val student: Student,
    val course: Course
) {
    companion object {
        fun fromDomain(data: Map<String, Any>): EnrollmentResponse {
            val enrollment = data["enrollment"] as Enrollment

            return EnrollmentResponse(
                code = enrollment.code,
                student = data["student"] as Student,
                course = data["course"] as Course
            )
        }
    }
}
