package br.com.amartins.springarchtecture.student.usecase.impl

import br.com.amartins.springarchtecture.student.constants.Message
import br.com.amartins.springarchtecture.student.domain.Student
import br.com.amartins.springarchtecture.student.exception.DataNotFoundException
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.usecase.FindAllStudentsUseCase
import org.springframework.stereotype.Service

@Service
class FindAllStudentsUseCaseImpl(
    private val repository: StudentRepository
) : FindAllStudentsUseCase {
    override fun execute(): List<Student> {
        val studentEntities = repository.findAllByActiveIsTrue()
        if (!studentEntities.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_STUDENT)
        }
        return studentEntities.get().map { it.toDomain() }
    }
}
