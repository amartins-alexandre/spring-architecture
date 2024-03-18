package br.com.amartins.springarchitecture.enrollment.application.domain

data class Student(
    val externalId: String,
    val name: String,
    val document: String
)
