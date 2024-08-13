package br.com.amartins.springarchitecture.enrollment.adapter.inbound.controller

import br.com.amartins.springarchitecture.enrollment.adapter.inbound.controller.request.EnrollmentRequest
import br.com.amartins.springarchitecture.enrollment.adapter.inbound.controller.response.EnrollmentResponse
import br.com.amartins.springarchitecture.enrollment.application.useCase.enrollment.*
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
@RequestMapping("enrollment")
class EnrollmentController(
    private val findOneEnrollmentUseCase: FindOneEnrollmentUseCase,
    private val findAllEnrollmentUseCase: FindAllEnrollmentUseCase,
    private val createEnrollmentUseCase: CreateEnrollmentUseCase,
    private val updateEnrollmentUseCase: UpdateEnrollmentUseCase,
    private val inactivateEnrollmentUseCase: InactivateEnrollmentUseCase,
) {
    @GetMapping("{externalId}")
    fun getOne(
        @PathVariable externalId: String,
    ): ResponseEntity<EnrollmentResponse> {
        val enrollmentMap = findOneEnrollmentUseCase.execute(externalId)
        return ResponseEntity.ok(EnrollmentResponse.fromAnyMap(enrollmentMap))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<EnrollmentResponse>> {
        val enrollments = findAllEnrollmentUseCase.execute()
        return ResponseEntity.ok(EnrollmentResponse.fromListAnyMap(enrollments))
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun newEnrollment(
        @RequestBody enrollmentRequest: EnrollmentRequest,
    ) {
        createEnrollmentUseCase.execute(enrollmentRequest.toDomain())
    }

    @PutMapping("{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCourse(
        @PathVariable externalId: String,
        @RequestBody enrollmentRequest: EnrollmentRequest,
    ) {
        updateEnrollmentUseCase.execute(enrollmentRequest.toDomain().copy(externalId = externalId))
    }

    @DeleteMapping("{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun inactivateCourse(
        @PathVariable externalId: String,
    ) {
        inactivateEnrollmentUseCase.execute(externalId)
    }
}
