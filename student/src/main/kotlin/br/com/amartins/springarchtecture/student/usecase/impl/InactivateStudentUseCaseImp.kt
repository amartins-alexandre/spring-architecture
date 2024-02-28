package br.com.amartins.springarchtecture.student.usecase.impl

import br.com.amartins.springarchtecture.student.constants.Message
import br.com.amartins.springarchtecture.student.exception.DataAlreadyExistsException
import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.usecase.FindStudentByIdUseCase
import br.com.amartins.springarchtecture.student.usecase.InactivateStudentUseCase
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class InactivateStudentUseCaseImp(
    private val repository: StudentRepository,
    private val findStudentByIdUseCase: FindStudentByIdUseCase
) : InactivateStudentUseCase {
    override fun execute(id: String) {
        try {
            val student = findStudentByIdUseCase.execute(id).copy(active = false)
            repository.save(student.toEntity())
        } catch (ex: DataIntegrityViolationException) {
            throw DataAlreadyExistsException(Message.STUDENT_ALREADY_EXISTS.replace("{}", id))
        }
    }
}
