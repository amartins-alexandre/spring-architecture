package br.com.amartins.springarchtecture.student.useCase.impl

import br.com.amartins.springarchtecture.student.domain.Student
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.useCase.FindStudentByIdUseCase
import org.springframework.stereotype.Service

@Service
class FindStudentByIdUseCaseImpl(
    private val repository: StudentRepository
) : FindStudentByIdUseCase {
    override fun execute(id: String): Student? {
        val entityOptional = repository.findById(id)
        return if (entityOptional.isPresent) {
            entityOptional.get().toDomain()
        } else {
            null
        }
    }
}
