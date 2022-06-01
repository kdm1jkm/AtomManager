package com.github.kdm1jkm.atomsystem.interactor.method

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.interactor.MainEntry
import com.github.kdm1jkm.atomsystem.interactor.student.StudentLogin
import com.github.kdm1jkm.atomsystem.interactor.student.StudentRegister

class MethodEntry(private val manager: ApplicationManager):Interactor {
    override fun run(): Interactor? {
        println("\n1. 전형등록")
        println("2. 로그인")
        println("3. 돌아가기")
        print("Enter: ")

        return when (readln()) {
            "1" -> MethodRegister(manager)
            "2" -> MethodLogin(manager)
            "3" -> MainEntry(manager)
            else -> run()
        }
    }
}