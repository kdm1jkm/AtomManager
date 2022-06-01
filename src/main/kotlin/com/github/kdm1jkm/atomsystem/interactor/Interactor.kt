package com.github.kdm1jkm.atomsystem.interactor

interface Interactor {
    // Return next interactor, if null, exit program
    fun run(): Interactor?
}