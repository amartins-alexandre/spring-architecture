package br.com.amartins.springarchitecture.course.adapter.inbound.controller

import br.com.amartins.springarchitecture.course.application.useCase.*
import br.com.amartins.springarchitecture.course.adapter.inbound.controller.request.CourseRequest
import br.com.amartins.springarchitecture.course.adapter.inbound.controller.response.CourseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("course")
class CourseController(
    private val findOneCourseUseCase: FindOneCourseUseCase,
    private val findAllCourseUseCase: FindAllCourseUseCase,
    private val createCourseUseCase: CreateCourseUseCase,
    private val updateCourseUseCase: br.com.amartins.springarchitecture.course.application.useCase.UpdateCourseUseCase,
    private val inactivateCourseUseCase: InactivateCourseUseCase,
) {
    @GetMapping("{code}")
    fun getOne(
        @PathVariable code: String,
    ): ResponseEntity<CourseResponse> {
        val course = findOneCourseUseCase.execute(code)
        return ResponseEntity.ok(CourseResponse.fromDomain(course))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<CourseResponse>> {
        val courses = findAllCourseUseCase.execute()
        return ResponseEntity.ok(
            courses.map { CourseResponse.fromDomain(it) },
        )
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun newCourse(
        @RequestBody courseRequest: CourseRequest,
    ) {
        createCourseUseCase.execute(courseRequest.toDomain())
    }

    @PutMapping("{external_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCourse(
        @PathVariable("external_id") externalId: String,
        @RequestBody courseRequest: CourseRequest,
    ) {
        updateCourseUseCase.execute(
            courseRequest.toDomain()
                .copy(externalId = externalId)
        )
    }

    @DeleteMapping("{external_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun inactivateCourse(
        @PathVariable("external_id") externalId: String,
    ) {
        inactivateCourseUseCase.execute(externalId)
    }
}
