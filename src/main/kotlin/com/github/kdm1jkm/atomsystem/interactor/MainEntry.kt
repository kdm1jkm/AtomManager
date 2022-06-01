package com.github.kdm1jkm.atomsystem.interactor

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.calculateOnce
import com.github.kdm1jkm.atomsystem.interactor.method.MethodEntry
import com.github.kdm1jkm.atomsystem.interactor.student.StudentEntry

class MainEntry(private val manager: ApplicationManager) : Interactor {
    override fun run(): Interactor? {
        println("1. 지원하는 사람용")
        println("2. 지원받는 사람용")
        println("3. 계산")
        println("4. 종료")
        print("Enter: ")
        return when (readln()) {
            "1" -> StudentEntry(manager)
            "2" -> MethodEntry(manager)
            "3" -> run{
                manager.calculateOnce()
                run()
            }
            "4" -> null
            else -> run()
        }
    }
}