package com.github.kdm1jkm

import org.jetbrains.exposed.sql.Database
import java.io.File

class DBManager(file: File) {
    init {
        Database.connect("jdbc:h2:${file.absolutePath}")
    }
}