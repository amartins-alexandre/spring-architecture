package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto.StudentDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("\${service.clients.student}")
interface StudentServiceClient {
    @GetMapping("/student/{id}")
    fun getStudentById(
        @PathVariable(value = "id") id: String
    ): StudentDTO
}
