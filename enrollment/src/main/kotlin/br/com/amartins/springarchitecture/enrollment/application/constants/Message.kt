package br.com.amartins.springarchitecture.enrollment.application.constants

class Message {
    companion object {
        const val ENROLLMENT_ALREADY_EXISTS = "Enrollment already exists with the given id: {}"
        const val COULD_NOT_FIND_COURSE =
            "We couldn't find this course. This may be 'cause it's inactive or does not exist in our database"

        // ERRORS
        const val UNEXPECTED_ERROR_SAVED = "An unexpected error occurred, this enrollment could not be saved!"
    }
}
