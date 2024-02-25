package br.com.amartins.springarchtecture.student.useCase.impl

import br.com.amartins.springarchtecture.student.domain.Student
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.useCase.CreateStudentUseCase
import br.com.amartins.springarchtecture.student.useCase.FindStudentById
import org.springframework.stereotype.Service

@Service
class CreateStudentUseCaseImpl(
    private val repository: StudentRepository,
    private val findStudentById: FindStudentById
) : CreateStudentUseCase {
    override fun execute(student: Student): Student {
        if (!student.id.isNullOrBlank() && findStudentById.execute(student.id) != null) {
            throw Exception("Student has exist: ${student.name}")
        }

        return repository.save(student.toEntity())
            .toDomain()
    }
}