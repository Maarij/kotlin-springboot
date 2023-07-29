package com.kotlinspringboot.classes

object Authenticate {
    fun authenticate(userName: String, password: String) {
        println("User authenticated for username: ${userName}")
    }
}

fun main() {
    Authenticate.authenticate("Maarij", "abc")
}