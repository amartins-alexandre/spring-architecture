package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto.CourseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "course-service", url = "\${service.clients.course}")
interface CourseServiceClient {
    @GetMapping("/course/{externalId}")
    fun getCourseByExternalId(
        @PathVariable(value = "externalId") externalId: String
    ): CourseDTO
}
