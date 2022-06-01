package com.github.kdm1jkm.atomsystem

import com.github.kdm1jkm.atomsystem.models.Application
import com.github.kdm1jkm.atomsystem.models.ApplicationMethod
import com.github.kdm1jkm.atomsystem.models.Student
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


@Suppress("OPT_IN_USAGE")
class ApplicationManager(private val file: File = File("./data.json")) {
    internal val data: DBData = if (file.isFile) {
        try {
            Json.decodeFromStream(FileInputStream(file))
        }
        catch (e: SerializationException){
            DBData(ArrayList(), ArrayList(), ArrayList())
        }
    } else {
        DBData(ArrayList(), ArrayList(), ArrayList())
    }

    fun save(save: File = file) {
        Json.encodeToStream(data, FileOutputStream(save))
    }

    @Serializable
    data class DBData(
        val applications: MutableList<Application>,
        val applicationMethods: MutableList<ApplicationMethod>,
        val students: MutableList<Student>
    )
}