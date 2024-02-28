package br.com.amartins.springarchtecture.student.controller

import br.com.amartins.springarchtecture.student.controller.dto.request.StudentRequest
import br.com.amartins.springarchtecture.student.controller.dto.response.StudentResponse
import br.com.amartins.springarchtecture.student.usecase.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("student")
class StudentController(
    private val findAllStudentsUseCase: FindAllStudentsUseCase,
    private val findStudentByIdUseCase: FindStudentByIdUseCase,
    private val createStudentUseCase: CreateStudentUseCase,
    private val updateStudentUseCase: UpdateStudentUseCase,
    private val inactivateStudentUseCase: InactivateStudentUseCase
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<StudentResponse>> {
        val foundStudents = findAllStudentsUseCase.execute().map { it.toResponse() }
        return ResponseEntity.ok(foundStudents)
    }

    @GetMapping("{id}")
    fun getOne(
        @PathVariable id: String,
    ): ResponseEntity<StudentResponse> {
        val foundStudent = findStudentByIdUseCase.execute(id = id).toResponse()
        return ResponseEntity.ok(foundStudent)
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createNewStudent(
        @RequestBody student: StudentRequest
    ) {
        createStudentUseCase.execute(student = student.toDomain())
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun updateStudentData(
        @PathVariable id: String,
        @RequestBody studentReq: StudentRequest,
    ): ResponseEntity<StudentResponse> {
        val student = studentReq.toDomain().copy(id = id)
        return ResponseEntity.ok(
            updateStudentUseCase.execute(student = student)
            .toResponse()
                )
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun logicRemoveStudent(
        @PathVariable id: String,
    ) {
        inactivateStudentUseCase.execute(id = id)
    }
}
