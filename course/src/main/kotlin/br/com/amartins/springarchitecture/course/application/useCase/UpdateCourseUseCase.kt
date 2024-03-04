package br.com.amartins.springarchitecture.course.application.useCase

import br.com.amartins.springarchitecture.course.application.domain.Course

interface UpdateCourseUseCase {
    fun execute(course: Course)
}
