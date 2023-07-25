package com.kotlinspringboot.functions

fun main() {
    printName("Maarij")
    val result = addition(1, 2)
    println("Result is $result")

    val result2 = addition2(1, 2)
    println("Result is $result")
}


fun addition2(x: Int, y: Int) = x + y

fun addition(x: Int, y: Int): Int {
    return x + y
}

fun printName(name: String): Unit {
    println("Name is: $name")
}
