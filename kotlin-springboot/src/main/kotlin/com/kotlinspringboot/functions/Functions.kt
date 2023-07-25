package com.kotlinspringboot.functions

import java.time.LocalDate

fun main() {
    printName("Maarij")
    val result = addition(1, 2)
    println("Result is $result")

    val result2 = addition2(1, 2)
    println("Result is $result")

    printPersonDetails("Maarij", "abc@gmail.com", LocalDate.parse("2000-01-01"))
    printPersonDetails("Maarij")
    printPersonDetails(name = "Maarij", dob = LocalDate.parse("2000-01-01"))
    printPersonDetails(dob = LocalDate.parse("2000-01-01"), name = "Maarij", email = "abc@gmail.com")
}

fun printPersonDetails(
    name: String,
    email: String = "",
    dob: LocalDate = LocalDate.now()
) {
    println("Name is $name and email is $email and dob is $dob")
}

fun addition2(x: Int, y: Int) = x + y

fun addition(x: Int, y: Int): Int {
    return x + y
}

fun printName(name: String): Unit {
    println("Name is: $name")
}
