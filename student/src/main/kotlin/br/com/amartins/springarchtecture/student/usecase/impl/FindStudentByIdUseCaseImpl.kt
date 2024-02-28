package br.com.amartins.springarchtecture.student.usecase.impl

import br.com.amartins.springarchtecture.student.constants.Message
import br.com.amartins.springarchtecture.student.domain.Student
import br.com.amartins.springarchtecture.student.exception.DataNotFoundException
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.usecase.FindStudentByIdUseCase
import org.springframework.stereotype.Service

@Service
class FindStudentByIdUseCaseImpl(
    private val repository: StudentRepository
) : FindStudentByIdUseCase {
    override fun execute(id: String): Student {
        val entityOptional = repository.findByIdAndActiveIsTrue(id)
        if (!entityOptional.isPresent) {
            throw DataNotFoundException(Message.COULD_NOT_FIND_STUDENT)
        }

        return entityOptional.get().toDomain()
    }
}
