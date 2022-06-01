package com.github.kdm1jkm.manager

import com.github.kdm1jkm.ApplicationManager
import com.github.kdm1jkm.models.ApplicationMethod

fun ApplicationManager.getApplicationMethods(): List<ApplicationMethod> {
    return data.applicationMethods
}

fun ApplicationManager.getMethodById(id: String): ApplicationMethod? {
    return data.applicationMethods.find { it.id == id }
}