package com.github.kdm1jkm.atomsystem.models

import kotlinx.serialization.Serializable

@Serializable
data class Application(
    val studentId: String,
    val methodId: String,
    val submittedContent: String,
    val state: State,
    val score: Int = 0
) {
    enum class State {
        NOT_RATED, RATED, ACCEPTED, DENIED
    }

    override fun toString() = "$studentId -> $methodId\n$submittedContent"
}
