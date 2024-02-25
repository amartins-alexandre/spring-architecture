package br.com.amartins.springarchtecture.student.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("student")
class StudentController {
    @GetMapping
    fun getAll() {}

    @GetMapping("{id}")
    fun getOne(
        @PathVariable id: String,
    ) {}

    @PostMapping
    fun createNewStudent(student: Any) {}

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
