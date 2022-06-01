package com.github.kdm1jkm

import com.github.kdm1jkm.models.Application
import com.github.kdm1jkm.models.ApplicationMethod
import com.github.kdm1jkm.models.Student
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


@Suppress("OPT_IN_USAGE")
class DBManager(file: File? = null) {
    private val data: DBData

    init {
        data = if (file == null || file.isFile) {
            DBData(ArrayList(), ArrayList(), ArrayList())
        } else {
            Json.decodeFromStream(FileInputStream(file))
        }
    }

    fun save(file: File) {
        Json.encodeToStream(data, FileOutputStream(file))
    }

    @Serializable
    data class DBData(
        val applications: MutableList<Application>,
        val applicationMethods: MutableList<ApplicationMethod>,
        val students: MutableList<Student>
    )
}