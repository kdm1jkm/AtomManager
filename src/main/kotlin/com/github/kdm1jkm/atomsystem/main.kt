package com.github.kdm1jkm.atomsystem

import com.github.kdm1jkm.atomsystem.interactor.Interactor
import com.github.kdm1jkm.atomsystem.interactor.MainEntry
import java.io.File

fun main() {
    var interactor: Interactor? = MainEntry(ApplicationManager(File("./data.json")))
    while (true) {
        if (interactor == null) break
        interactor = interactor.run()
    }

}