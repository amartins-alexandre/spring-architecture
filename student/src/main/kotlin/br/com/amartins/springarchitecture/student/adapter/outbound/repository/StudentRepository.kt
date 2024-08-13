package br.com.amartins.springarchitecture.student.adapter.outbound.repository

import br.com.amartins.springarchitecture.student.adapter.outbound.repository.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface StudentRepository : JpaRepository<StudentEntity, String> {
    fun findByExternalIdAndActiveIsTrue(externalId: String): Optional<StudentEntity>

    fun findAllByActiveIsTrue(): Optional<List<StudentEntity>>
}
