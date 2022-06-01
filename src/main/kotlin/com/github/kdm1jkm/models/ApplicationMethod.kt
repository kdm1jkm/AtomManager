package com.github.kdm1jkm.models

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationMethod(
    val id: String,
    val name: String,
    val content: String
)
