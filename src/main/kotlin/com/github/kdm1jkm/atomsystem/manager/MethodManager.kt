package com.github.kdm1jkm.atomsystem.manager

import com.github.kdm1jkm.atomsystem.ApplicationManager
import com.github.kdm1jkm.atomsystem.models.ApplicationMethod

fun ApplicationManager.getApplicationMethods(): List<ApplicationMethod> {
    return data.applicationMethods
}

fun ApplicationManager.getMethodById(id: String): ApplicationMethod? {
    return data.applicationMethods.find { it.id == id }
}