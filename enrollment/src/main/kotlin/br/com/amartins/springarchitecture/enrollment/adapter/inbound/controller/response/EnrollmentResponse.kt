package br.com.amartins.springarchitecture.enrollment.adapter.inbound.controller.response

import br.com.amartins.springarchitecture.enrollment.application.domain.Course
import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import br.com.amartins.springarchitecture.enrollment.application.domain.Student
import com.fasterxml.jackson.annotation.JsonProperty

data class EnrollmentResponse(
    @JsonProperty(value = "external_id") val externalId: String,
    val student: Student,
    val course: Course
) {
    companion object {
        fun fromAnyMap(data: Map<String, Any>): EnrollmentResponse {
            val enrollment = data["enrollment"] as Enrollment

            return EnrollmentResponse(
                externalId = enrollment.externalId!!,
                student = data["student"] as Student,
                course = data["course"] as Course
            )
        }

        fun fromListAnyMap(data: List<Map<String, Any>>): List<EnrollmentResponse> {
            val enrollments = ArrayList<EnrollmentResponse>()

            data.forEach {
                val enrollment = it["enrollment"] as Enrollment
                val student = it["student"] as Student
                val course = it["course"] as Course

                enrollments.add(
                    EnrollmentResponse(
                        externalId = enrollment.externalId!!,
                        student = student,
                        course = course
                    )
                )
            }

            return enrollments
        }
    }
}
