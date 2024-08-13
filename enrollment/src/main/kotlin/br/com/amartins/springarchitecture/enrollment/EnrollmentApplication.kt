package br.com.amartins.springarchitecture.enrollment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class EnrollmentApplication

fun main(args: Array<String>) {
    runApplication<EnrollmentApplication>(*args)
}
