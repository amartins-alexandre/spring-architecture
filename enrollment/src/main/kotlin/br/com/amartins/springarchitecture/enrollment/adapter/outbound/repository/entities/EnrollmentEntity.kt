package br.com.amartins.springarchitecture.enrollment.adapter.outbound.repository.entities

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity(name = "enrollment")
data class EnrollmentEntity(
    @Id val id: String?,
    @Column val code: String,
    @Column val studentId: String,
    @Column val courseCode: String,
    @Column val active: Boolean,
) {
    fun toDomain(): Enrollment =
        Enrollment(
            id = this.id,
            code = this.code,
            studentId = this.studentId,
            courseCode = this.courseCode,
            active = this.active,
        )

    companion object {
        fun fromDomain(enrollment: Enrollment) =
            EnrollmentEntity(
                id = enrollment.id ?: this.newEnrollment(),
                code = enrollment.code!!,
                studentId = enrollment.studentId,
                courseCode = enrollment.courseCode,
                active = enrollment.active,
            )

        private fun newEnrollment(): String =
            UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 21)
    }
}
