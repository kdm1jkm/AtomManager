package com.github.kdm1jkm.models

data class Application(
    val studentId: Int,
    val schoolId: Int,
    @Suppress("ArrayInDataClass") val submittedContent: ByteArray,
    val state: State
) {
    enum class State {
        NOT_RATED, RATED, ACCEPTED, DENIED
    }
}
