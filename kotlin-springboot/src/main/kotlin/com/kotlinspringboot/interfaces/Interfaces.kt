package com.kotlinspringboot.interfaces

import com.kotlinspringboot.classes.Course

interface CourseRepository {
    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("course : $course")
        return course.id
    }
}

interface Repository {
    fun getAll(): Any
}

class SqlCourseRepository : CourseRepository, Repository {
    override fun getById(id: Int): Course {
        return Course(
            id,
            "Reactive Programming in Modern Java using Project Reactor",
            "Maarij"
        )
    }

    override fun getAll(): Any {
        return 1
    }
}

class NoSqlCourseRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(
            id,
            "Reactive Programming in Modern Java using Project Reactor",
            "Maarij"
        )
    }

    override fun save(course: Course): Int {
        println("course in NoSqlCourseRepository : $course")
        return course.id
    }
}


fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(2)
    println("Course is $course")
    val courseId = sqlCourseRepository.save(
        Course(
            5,
            "Reactive Programming in Modern Java using Project Reactor",
            "Maarij"
        )
    )

    println("Saved Course Id is : $courseId")

    val nosqlCourseRepository = NoSqlCourseRepository()
    val course1 = nosqlCourseRepository.getById(2)
    println("Course is $course1")
    val savedCourseId = nosqlCourseRepository.save(
        Course(
            6,
            "Reactive Programming in Modern Java using Project Reactor",
            "Maarij"
        )
    )

    println("Saved Course Id in nosqlCourseRepository : $savedCourseId")
}