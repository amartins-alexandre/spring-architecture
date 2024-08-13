package br.com.amartins.springarchitecture.enrollment.adapter.outbound.repository

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.repository.entities.EnrollmentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EnrollmentRepository : JpaRepository<EnrollmentEntity, String> {
    fun findByExternalIdAndActiveIsTrue(externalId: String): Optional<EnrollmentEntity>

    fun findAllByActiveIsTrue(): Optional<List<EnrollmentEntity>>
}
