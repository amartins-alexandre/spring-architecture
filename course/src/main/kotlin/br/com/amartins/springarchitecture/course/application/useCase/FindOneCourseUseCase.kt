package br.com.amartins.springarchitecture.course.application.useCase

import br.com.amartins.springarchitecture.course.application.domain.Course

interface FindOneCourseUseCase {
    fun execute(code: String): Course
}
