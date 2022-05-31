package com.github.kdm1jkm.models

data class ApplicationMethod(
    val userId: String,
    val name: String,
    @Suppress("ArrayInDataClass") val content: ByteArray
)