package br.com.amartins.springarchitecture.course.application.constants

class Message {
    companion object {
        const val COURSE_ALREADY_EXISTS = "Course already exists with the given name: {}"
        const val COULD_NOT_FIND_COURSE =
            "We couldn't find this course. This may be 'cause it's inactive or does not exist in our database"
        const val COURSE_ALREADY_INACTIVATED = "Course already inactivated with the given external id: {}"
        const val COURSE_INACTIVATED = "Course with external id '{}' inactivated"

        // ERRORS
        const val UNEXPECTED_ERROR = "An unexpected error occurred, this course could not be saved!"
    }
}
