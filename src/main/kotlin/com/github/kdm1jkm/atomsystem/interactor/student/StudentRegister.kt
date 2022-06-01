package com.github.kdm1jkm.atomsystem.interactor.student

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.manager.registerStudent
import com.github.kdm1jkm.atomsystem.models.Student

class StudentRegister(private val manager: ApplicationManager) :
    Interactor {
    override fun run(): Interactor {
        println("--회원가입--")
        print("id를 입력하세요: ")
        val id = readln()
        print("이름을 입력하세요: ")
        val name = readln()

        try {
            manager.registerStudent(Student(id, name))
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }

        manager.save()

        return StudentEntry(manager)
    }
}