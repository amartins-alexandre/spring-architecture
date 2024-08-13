package br.com.amartins.springarchitecture.course.adapter.outbound.repository.entities

import br.com.amartins.springarchitecture.course.application.domain.Course
import br.com.amartins.springarchitecture.course.application.domain.enums.CourseType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity(name = "course")
data class CourseEntity(
    @Id val id: String?,
    @Column(name = "external_id") val externalId: String?,
    @Column val name: String,
    @Column val type: String,
    @Column val active: Boolean,
) {
    fun toDomain(): Course =
        Course(
            id = this.id,
            name = this.name,
            externalId = this.externalId,
            type = CourseType.valueOf(this.type),
            active = this.active,
        )

    companion object {
        fun fromDomain(course: Course) =
            CourseEntity(
                id = course.id ?: this.generateNanoId(),
                name = course.name,
                externalId = course.externalId ?: this.generateNanoId(),
                type = course.type.name,
                active = course.active,
            )

        private fun generateNanoId(maxLen: Int = 21): String =
            UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, maxLen)
    }
}
