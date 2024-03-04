package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto.CourseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("\${service.clients.course}")
interface CourseServiceClient {
    @GetMapping("/course/{id}")
    fun getCourseById(
        @PathVariable(value = "id") id: String
    ): CourseDTO
}
