package br.com.amartins.springarchtecture.student.usecase.impl

import br.com.amartins.springarchtecture.student.domain.Student
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.usecase.FindAllStudentsUseCase
import org.springframework.stereotype.Service

@Service
class FindAllStudentsUseCaseImpl(
    private val repository: StudentRepository
) : FindAllStudentsUseCase {
    override fun execute(): List<Student> {
        val studentEntities = repository.findAllByActiveIsTrue()
        return studentEntities.get().map { it.toDomain() }
    }
}
