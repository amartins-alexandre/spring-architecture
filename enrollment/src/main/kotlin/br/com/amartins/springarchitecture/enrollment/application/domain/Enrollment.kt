package br.com.amartins.springarchitecture.enrollment.application.domain

import java.util.*

data class Enrollment(
    val id: String? = null,
    val externalId: String? = null,
    val studentExternalId: String,
    val courseExternalId: String,
    val active: Boolean = true,
)
