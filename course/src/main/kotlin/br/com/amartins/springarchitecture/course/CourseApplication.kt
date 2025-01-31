package br.com.amartins.springarchitecture.course

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CourseApplication

fun main(args: Array<String>) {
    runApplication<CourseApplication>(*args)
}
