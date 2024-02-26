package br.com.amartins.springarchtecture.student.controller

import br.com.amartins.springarchtecture.student.controller.dto.request.StudentRequest
import br.com.amartins.springarchtecture.student.controller.dto.response.StudentResponse
import br.com.amartins.springarchtecture.student.useCase.CreateStudentUseCase
import br.com.amartins.springarchtecture.student.useCase.FindStudentByIdUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("student")
class StudentController(
    private val findStudentByIdUseCase: FindStudentByIdUseCase,
    private val createStudentUseCase: CreateStudentUseCase
) {
    @GetMapping
    fun getAll() {}

    @GetMapping("{id}")
    fun getOne(
        @PathVariable id: String,
    ): StudentResponse? = findStudentByIdUseCase.execute(id)?.toResponse()

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createNewStudent(
        @RequestBody student: StudentRequest
    ) {
        createStudentUseCase.execute(student = student.toDomain())
    }

    @PutMapping("{id}")
    fun updateStudentData(
        @PathVariable id: String,
        @RequestBody student: Any,
    ) {}

    @DeleteMapping("{id}")
    fun logicRemoveStudent(
        @PathVariable id: String,
    ) {}
}
