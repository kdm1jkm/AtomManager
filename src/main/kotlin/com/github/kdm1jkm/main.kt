package com.github.kdm1jkm

import java.io.File

fun main() {
    val manager = DBManager()
    manager.save(File("./data.json"))
}