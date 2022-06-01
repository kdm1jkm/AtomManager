package com.github.kdm1jkm.atomsystem.manager

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.models.Application
import com.github.kdm1jkm.atomsystem.models.Application.State.RATED
import com.github.kdm1jkm.atomsystem.models.ApplicationMethod

fun ApplicationManager.registerMethod(method: ApplicationMethod) {
    with(data.applicationMethods) {
        if (any { it.id == method.id }) {
            throw IllegalArgumentException("Method id ${method.id} already exist.")
        }

        add(method)
    }
}

fun ApplicationManager.getApplicationMethods(): List<ApplicationMethod> {
    return data.applicationMethods
}

fun ApplicationManager.getMethodById(id: String): ApplicationMethod? {
    return data.applicationMethods.find { it.id == id }
}

fun ApplicationManager.rateApplication(method:Application, score: Int) {
    data.applications.remove(method)
    data.applications.add(method.copy(score = score, state = RATED))
}