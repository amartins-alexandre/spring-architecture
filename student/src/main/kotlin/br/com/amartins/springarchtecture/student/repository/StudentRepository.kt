package br.com.amartins.springarchtecture.student.repository

import br.com.amartins.springarchtecture.student.repository.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface StudentRepository : JpaRepository<StudentEntity, String> {
    fun findByIdAndActiveIsTrue(id: String): Optional<StudentEntity>

    fun findAllByActiveIsTrue(): Optional<List<StudentEntity>>
}
