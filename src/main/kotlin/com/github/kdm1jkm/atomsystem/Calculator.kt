package com.github.kdm1jkm.atomsystem

import com.github.kdm1jkm.atomsystem.models.Application
import com.github.kdm1jkm.atomsystem.models.Application.State.RATED


/**
 * @return 변경한 횟수
 */
fun ApplicationManager.calculateOnce(): Int {
    data.applications
        .filter { it.state  == RATED }
        .sortedByDescending { it.score }
        .groupBy { it.methodId }
        .forEach { println(it) }

    return 1
}