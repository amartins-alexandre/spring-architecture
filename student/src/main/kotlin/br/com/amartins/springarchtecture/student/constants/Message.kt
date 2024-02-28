package br.com.amartins.springarchtecture.student.constants

class Message {
    companion object {
        const val STUDENT_ALREADY_EXISTS = "Student already exists with the given id: {}"
        const val STUDENT_ALREADY_EXISTS_DOCUMENT = "Student already exists with the given document: {}"
        const val COULD_NOT_FIND_STUDENT =
            "We couldn't find this student. This may be 'cause it's inactive or does not exist in our database"

        // ERRORS
        const val UNEXPECTED_ERROR = "An unexpected error occurred, this student could not be saved!"
    }
}
