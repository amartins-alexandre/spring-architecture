package br.com.amartins.springarchitecture.student.adapter.inbound.controller

import br.com.amartins.springarchitecture.student.application.usecase.*
import br.com.amartins.springarchitecture.student.adapter.inbound.controller.request.StudentRequest
import br.com.amartins.springarchitecture.student.adapter.inbound.controller.response.StudentResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("student")
class StudentController(
    private val findAllStudentsUseCase: FindAllStudentsUseCase,
    private val findOneStudentUseCase: FindOneStudentUseCase,
    private val createStudentUseCase: CreateStudentUseCase,
    private val updateStudentUseCase: UpdateStudentUseCase,
    private val inactivateStudentUseCase: InactivateStudentUseCase
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<StudentResponse>> {
        val foundStudents = findAllStudentsUseCase.execute()
        return ResponseEntity.ok(
            foundStudents.map { StudentResponse.fromDomain(it) }
        )
    }

    @GetMapping("{externalId}")
    fun getOne(
        @PathVariable externalId: String,
    ): ResponseEntity<StudentResponse> {
        val foundStudent = findOneStudentUseCase.execute(externalId = externalId)
        return ResponseEntity.ok(StudentResponse.fromDomain(foundStudent))
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createNewStudent(
        @RequestBody studentRequest: StudentRequest
    ) {
        createStudentUseCase.execute(studentRequest.toDomain())
    }

    @PutMapping("{externalId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun updateStudentData(
        @PathVariable externalId: String,
        @RequestBody studentRequest: StudentRequest,
    ) {
        updateStudentUseCase.execute(
            studentRequest.toDomain()
                .copy(externalId = externalId)
        )
    }

    @DeleteMapping("{externalId}")
    fun logicRemoveStudent(
        @PathVariable externalId: String,
    ): ResponseEntity<String> =
        ResponseEntity.ok(
            inactivateStudentUseCase.execute(externalId = externalId)
        )
}
