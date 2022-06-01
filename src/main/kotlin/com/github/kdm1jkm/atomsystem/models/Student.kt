package com.github.kdm1jkm.atomsystem.models

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val id: String,
    val name: String
)