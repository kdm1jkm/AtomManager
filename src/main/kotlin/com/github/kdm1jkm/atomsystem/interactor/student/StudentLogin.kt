package com.github.kdm1jkm.atomsystem.interactor.student

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.manager.getStudentById

class StudentLogin(private val manager: ApplicationManager) :
    Interactor {
    override fun run(): Interactor {
        println("--로그인--")
        print("id를 입력하세요: ")
        val student = manager.getStudentById(readln())

        return if (student == null) {
            println("해당 id는 존재하지 않습니다.")
            StudentEntry(manager)
        } else {
            println("${student.name}님으로 로그인 하였습니다.")
            StudentMain(manager, student)
        }
    }

}