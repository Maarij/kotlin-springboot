package com.kotlinspringboot.basics

fun main() {
    /*    val range = 1..10
        for (i in range) {
            println("i: $i")
        }

        val reverseRange = 10 downTo  2
        for (i in reverseRange) {
            println("i: $i")
        }

        for (i in reverseRange step 2) {
            println("i: $i")
        }*/

    exploreWhile()
    exploreDoWhile()
}

fun exploreDoWhile() {
    var i = 0
    do {
        println("Value of i is $i")
        i++
    } while (i < 5)
}

fun exploreWhile() {
    var x = 1
    while (x < 5) {
        println("Value of x is $x")
        x++
    }
}
