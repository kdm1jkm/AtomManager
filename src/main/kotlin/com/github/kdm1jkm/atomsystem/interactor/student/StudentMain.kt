package com.github.kdm1jkm.atomsystem.interactor.student

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.manager.getApplicationMethods
import com.github.kdm1jkm.atomsystem.manager.getApplied
import com.github.kdm1jkm.atomsystem.models.Student

class StudentMain(private val manager: ApplicationManager, private val student: Student) : Interactor {
    override fun run(): Interactor? {
        println("현재 ${student.name}님으로 로그인되어 있습니다.")
        println("1. 지원 가능 원서 확인")
        println("2. 지원한 원서 목록 확인")
        println("3. 원서 지원하기")
        println("4. 로그아웃")
        print("Enter: ")

        return when (readln()) {
            "1" -> run {
                println("--원서 목록--")
                manager.getApplicationMethods()
                    .map { "${it.name}(id: ${it.id})" }
                    .let { println(it) }

                run()
            }
            "2" -> run {
                println("--지원한 원서 목록--")
                manager.getApplied(student)
                    .map { it.schoolId }
                    .let { println(it) }

                run()
            }
            "3" -> StudentApply(manager, student)
            "4" -> StudentEntry(manager)
            else -> run()
        }
    }
}