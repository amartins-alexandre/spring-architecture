package br.com.amartins.springarchtecture.student.usecase.impl

import br.com.amartins.springarchtecture.student.repository.StudentRepository
import br.com.amartins.springarchtecture.student.usecase.FindStudentByIdUseCase
import br.com.amartins.springarchtecture.student.usecase.InactivateStudentUseCase
import org.springframework.stereotype.Service

@Service
class InactivateStudentUseCaseImp(
    private val repository: StudentRepository,
    private val findStudentByIdUseCase: FindStudentByIdUseCase
) : InactivateStudentUseCase {
    override fun execute(id: String) {
        val student = findStudentByIdUseCase.execute(id).copy(active = false)
        repository.save(student.toEntity())
    }
}
