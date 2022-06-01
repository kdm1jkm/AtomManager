package com.github.kdm1jkm.atomsystem

import com.github.kdm1jkm.atomsystem.manager.getStudentById
import com.github.kdm1jkm.atomsystem.manager.tryAccept
import com.github.kdm1jkm.atomsystem.models.Application.State.RATED


/**
 * @return 변경한 횟수
 */
fun ApplicationManager.calculateOnce(): Int {
    var count = 0
    data.applications
        .filter { it.state == RATED }
        .groupBy { it.methodId }
        .map { it.value }
        .forEach { applications ->
            applications
                .sortedByDescending { it.score }
                .forEach {
                    if (tryAccept(getStudentById(it.studentId) ?: throw IllegalStateException(), it)) count++
                }
        }

    save()
    println("count: $count")
    return count
}