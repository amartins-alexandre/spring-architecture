package br.com.amartins.springarchitecture.student.adapter.outbound.repository.entity

import br.com.amartins.springarchitecture.student.application.domain.Student
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.apache.logging.log4j.util.Strings
import java.util.*

@Entity(name = "student")
class StudentEntity(
    @Id val id: String?,
    @Column(name = "external_id") private val externalId: String,
    @Column private val name: String,
    @Column(length = 11) private val document: String,
    @Column private val active: Boolean = true
) {
    constructor() : this(
        id = null,
        externalId = Strings.EMPTY,
        name = Strings.EMPTY,
        document = Strings.EMPTY
    )

    fun toDomain(): Student =
        Student(
            id = this.id,
            externalId = this.externalId,
            name = this.name,
            document = this.document,
            active = this.active
        )

    companion object {
        fun fromDomain(student: Student): StudentEntity =
            StudentEntity(
            id = student.id ?: this.generateNanoId(),
            externalId = student.externalId ?: this.generateNanoId(),
            name = student.name,
            document = student.document,
            active = student.active
        )

        private fun generateNanoId(maxLen: Int = 21): String =
            UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, maxLen)
    }
}
