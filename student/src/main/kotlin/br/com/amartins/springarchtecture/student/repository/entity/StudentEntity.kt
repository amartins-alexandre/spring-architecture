package br.com.amartins.springarchtecture.student.repository.entity

import br.com.amartins.springarchtecture.student.domain.Student
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "student")
class StudentEntity(
    @Id val id: String?,
    @Column private val name: String,
    @Column(length = 11) private val document: String
) {
    fun toDomain(): Student =
        Student(
        id = this.id,
        name = this.name,
        document = this.document
    )

    protected constructor() : this(
        id = null,
        name = "",
        document = ""
    )
}
