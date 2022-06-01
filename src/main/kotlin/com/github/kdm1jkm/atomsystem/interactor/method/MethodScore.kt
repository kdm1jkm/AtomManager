package com.github.kdm1jkm.atomsystem.interactor.method

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.manager.getApplied
import com.github.kdm1jkm.atomsystem.manager.rateApplication
import com.github.kdm1jkm.atomsystem.models.Application.State.NOT_RATED
import com.github.kdm1jkm.atomsystem.models.ApplicationMethod

class MethodScore(private val manager: ApplicationManager, private val method: ApplicationMethod) : Interactor {
    override fun run(): Interactor {
        println()
        manager.getApplied(method)
            .filter { it.state == NOT_RATED }
            .forEach {
                println("----------")
                println(it.submittedContent)
                println("----------")
                print("점수 입력: ")
                val score = run {
                    var input: Int? = null
                    while (input == null)
                        input = readln().toIntOrNull()
                    input
                }

                manager.rateApplication(it, score)
            }

        manager.save()

        return MethodMain(manager, method)
    }
}