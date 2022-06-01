package com.github.kdm1jkm.atomsystem.interactor.method

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.manager.getMethodById

class MethodLogin(private val manager: ApplicationManager) : Interactor {
    override fun run(): Interactor? {
        println("--로그인--")
        print("id를 입력하세요: ")
        val method = manager.getMethodById(readln())

        return if (method == null) {
            println("해당 id는 존재하지 않습니다.")
            MethodEntry(manager)
        } else {
            println("${method.name}님으로 로그인 하였습니다.")
            MethodMain(manager, method)
        }
    }
}