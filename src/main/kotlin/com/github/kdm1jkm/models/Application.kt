package com.github.kdm1jkm.models

import kotlinx.serialization.Serializable

@Serializable
data class Application(
    val studentId: String,
    val schoolId: String,
    val submittedContent: String,
    val state: State
) {
    enum class State {
        NOT_RATED, RATED, ACCEPTED, DENIED
    }
}
