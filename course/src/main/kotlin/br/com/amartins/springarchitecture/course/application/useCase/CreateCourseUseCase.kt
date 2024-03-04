package br.com.amartins.springarchitecture.course.application.useCase

import br.com.amartins.springarchitecture.course.application.domain.Course

interface CreateCourseUseCase {
    fun execute(course: Course)
}
