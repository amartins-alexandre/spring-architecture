package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.dto.StudentDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "student-service", url = "\${service.clients.student}")
interface StudentServiceClient {
    @GetMapping("/student/{externalId}")
    fun getStudentByExternalId(
        @PathVariable(value = "externalId") externalId: String
    ): StudentDTO
}
