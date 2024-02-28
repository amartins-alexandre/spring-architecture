package br.com.amartins.springarchtecture.student.usecase.impl

import br.com.amartins.springarchtecture.student.domain.Student
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.usecase.UpdateStudentUseCase
import org.springframework.stereotype.Service

@Service
class UpdateStudentUseCaseImpl(
    private val repository: StudentRepository
) : UpdateStudentUseCase {
    override fun execute(student: Student): Student = repository.save(student.toEntity()).toDomain()
}
