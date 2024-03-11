package br.com.amartins.springarchitecture.student.application.constants

class Message {
    companion object {
        const val STUDENT_ALREADY_EXISTS = "Student already exists with the given external id: {}"
        const val STUDENT_ALREADY_EXISTS_DOCUMENT = "Student already exists with the given document: {}"
        const val COULD_NOT_FIND_STUDENT =
            "We couldn't find this student. This may be 'cause it's inactive or does not exist in our database"
        const val STUDENT_INACTIVATED = "Student with external id '{}' inactivated"
        const val STUDENT_ALREADY_INACTIVATED = "Student already inactivated with the given external id: {}"

        // ERRORS
        const val UNEXPECTED_ERROR = "An unexpected error occurred, this student could not be saved!"
    }
}
