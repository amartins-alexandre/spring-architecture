package br.com.amartins.springarchitecture.enrollment.application.domain

import java.util.*

data class Enrollment(
    val id: String? = null,
    val code: String? = null,
    val studentId: String,
    val courseCode: String,
    val active: Boolean = true,
) {
    private fun newEnrollment(maxLen: Int = 21): String =
        UUID.randomUUID()
            .toString()
            .replace("-", "")
            .substring(0, maxLen)
}
