package br.com.amartins.springarchitecture.enrollment.adapter.outbound.repository.entities

import br.com.amartins.springarchitecture.enrollment.application.domain.Enrollment
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity(name = "enrollment")
data class EnrollmentEntity(
    @Id val id: String?,
    @Column(name = "external_id") val externalId: String,
    @Column(name = "student_external_id") val studentExternalId: String,
    @Column(name = "course_external_id") val courseExternalId: String,
    @Column val active: Boolean,
) {
    fun toDomain(): Enrollment =
        Enrollment(
            id = this.id,
            externalId = this.externalId,
            studentExternalId = this.studentExternalId,
            courseExternalId = this.courseExternalId,
            active = this.active,
        )

    companion object {
        fun fromDomain(enrollment: Enrollment) =
            EnrollmentEntity(
                id = enrollment.id ?: this.newEnrollment(),
                externalId = enrollment.externalId ?: this.newEnrollment(),
                studentExternalId = enrollment.studentExternalId,
                courseExternalId = enrollment.courseExternalId,
                active = enrollment.active,
            )

        private fun newEnrollment(): String =
            UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 21)
    }
}
