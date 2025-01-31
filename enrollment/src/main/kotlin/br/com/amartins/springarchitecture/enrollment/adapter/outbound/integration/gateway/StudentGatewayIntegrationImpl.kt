package br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.gateway

import br.com.amartins.springarchitecture.enrollment.adapter.outbound.integration.client.StudentServiceClient
import br.com.amartins.springarchitecture.enrollment.application.domain.Student
import br.com.amartins.springarchitecture.enrollment.application.gateway.integration.StudentGatewayIntegration
import org.springframework.stereotype.Component

@Component
class StudentGatewayIntegrationImpl(
    private val studentServiceClient: StudentServiceClient
) : StudentGatewayIntegration {
    override fun getByExternalId(studentExternalId: String): Student {
        return studentServiceClient.getStudentByExternalId(studentExternalId).toDomain()
    }
}
