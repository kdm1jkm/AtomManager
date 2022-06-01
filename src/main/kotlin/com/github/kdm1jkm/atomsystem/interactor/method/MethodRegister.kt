package com.github.kdm1jkm.atomsystem.interactor.method

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.manager.registerMethod
import com.github.kdm1jkm.atomsystem.models.ApplicationMethod

class MethodRegister(private val manager: ApplicationManager) : Interactor {
    override fun run(): Interactor {
        println("--전형 등록--")
        print("id를 입력하세요: ")
        val id = readln()
        print("이름을 입력하세요: ")
        val name = readln()

        println("지원서 양식 작성, 작성 완료후엔 빈 줄에서 enter.")
        val content = StringBuilder().run {
            var new: String
            while (true) {
                print(" ")
                new = readln()
                if (new == "") break
                append(new)
                append("\n")
            }
            toString()
        }

        try {
            manager.registerMethod(ApplicationMethod(id, name, content))
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        manager.save()

        return MethodEntry(manager)
    }
}