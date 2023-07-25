import com.kotlinspringboot.functions.courseName
import com.kotlinspringboot.functions.topLevelFunction

fun main() {
    val name = "Maarij"
    println(name);

//    name = "Maarij1"

    var age = 33
    println(age)
    age = 34
    println(age)

    val salary = 10L
    println(salary)

    var course = "Kotlin Spring"
    println("course: $course and the course length is ${course.length}")

    val multiLine = "ABC \n DEF"
    println(multiLine)

    val multiLine1 = """
        ABC
        DEF
    """.trimIndent()
    println(multiLine1)

    val num = topLevelFunction()
    println("Num is $num")
    println("course name is $courseName")

}