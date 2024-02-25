package br.com.amartins.springarchtecture.msone.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    @Value("\${ms-one.value}") private val value: Int,
) {
    @GetMapping
    fun home(): String = "Hello World - $value!"
}
