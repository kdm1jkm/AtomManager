package com.github.kdm1jkm.models

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val id: String,
    val name: String
)