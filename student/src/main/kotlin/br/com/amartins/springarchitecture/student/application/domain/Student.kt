package br.com.amartins.springarchitecture.student.application.domain

data class Student(
    val id: String? = null,
    val externalId: String? = null,
    val name: String,
    val document: String,
    val active: Boolean = true
)
