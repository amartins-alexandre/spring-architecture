package br.com.amartins.springarchtecture.student.usecase.impl

import br.com.amartins.springarchtecture.student.constants.Message
import br.com.amartins.springarchtecture.student.domain.Student
import br.com.amartins.springarchtecture.student.exception.DataAlreadyExistsException
import br.com.amartins.springarchtecture.student.exception.StudentNotSavedException
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.usecase.CreateStudentUseCase
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class CreateStudentUseCaseImpl(
    private val repository: StudentRepository,
) : CreateStudentUseCase {
    override fun execute(student: Student): Boolean =
        try {
            val studentEntity = repository.save(student.toEntity())
            if (studentEntity.id.isNullOrEmpty()) {
                throw StudentNotSavedException(Message.UNEXPECTED_ERROR)
            }
            true
        } catch (ex: DataIntegrityViolationException) {
            throw DataAlreadyExistsException(
                Message.STUDENT_ALREADY_EXISTS_DOCUMENT.replace(
                    "{}",
                    student.document
                )
            )
        }
}
