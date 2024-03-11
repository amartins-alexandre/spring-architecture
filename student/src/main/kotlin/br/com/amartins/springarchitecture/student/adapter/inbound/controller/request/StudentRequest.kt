package br.com.amartins.springarchitecture.student.adapter.inbound.controller.request

import br.com.amartins.springarchitecture.student.application.domain.Student
import com.fasterxml.jackson.annotation.JsonAutoDetect
import org.apache.logging.log4j.util.Strings

@JsonAutoDetect
data class StudentRequest(
    val name: String,
    val document: String?,
) {
    fun toDomain(): Student =
        Student(
            name = this.name,
            document = this.document ?: Strings.EMPTY,
        )
}
