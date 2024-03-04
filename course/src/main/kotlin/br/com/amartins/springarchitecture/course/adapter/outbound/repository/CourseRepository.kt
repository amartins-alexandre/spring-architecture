package br.com.amartins.springarchitecture.course.adapter.outbound.repository

import br.com.amartins.springarchitecture.course.adapter.outbound.repository.entities.CourseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourseRepository : JpaRepository<CourseEntity, String> {
    fun findAllByActiveIsTrue(): Optional<List<CourseEntity>>

    fun findByExternalIdAndActiveIsTrue(externalId: String): Optional<CourseEntity>
}
