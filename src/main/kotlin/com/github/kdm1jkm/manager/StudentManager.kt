package com.github.kdm1jkm.manager

import com.github.kdm1jkm.ApplicationManager
import com.github.kdm1jkm.ApplicationManager.Companion.MAX_APPLICATION
import com.github.kdm1jkm.models.Application
import com.github.kdm1jkm.models.ApplicationMethod
import com.github.kdm1jkm.models.Student

fun ApplicationManager.registerStudent(student: Student) {
    with(data.students) {
        if (any { it.id == student.id }) {
            throw IllegalArgumentException("Student id ${student.id} already exist.")
        }

        add(student)
    }
}

fun ApplicationManager.getApplied(student: Student): List<Application> {
    return data.applications.filter {
        it.studentId == student.id
    }
}

fun ApplicationManager.apply(student: Student, applicationMethod: ApplicationMethod, content: String) {
    if (getApplied(student).size > MAX_APPLICATION)
        throw IllegalStateException("Already applied $MAX_APPLICATION application.")

    data.applications.add(Application(student.id, applicationMethod.id, content, Application.State.NOT_RATED))
}

fun ApplicationManager.getStudentById(id: String): Student? {
    return data.students.find { it.id == id }
}
