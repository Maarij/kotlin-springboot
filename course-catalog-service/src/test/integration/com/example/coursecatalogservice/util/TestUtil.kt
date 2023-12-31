package com.example.coursecatalogservice.util

import com.example.coursecatalogservice.dto.CourseDto
import com.example.coursecatalogservice.entity.Course

fun courseEntityList() = listOf(
    Course(
        null,
        "Build RestFul APis using SpringBoot and Kotlin", "Development"
    ),
    Course(
        null,
        "Build Reactive Microservices using Spring WebFlux/SpringBoot", "Development",
    ),
    Course(
        null,
        "Wiremock for Java Developers", "Development",
    )
)

fun CourseDto(
    id: Int? = null,
    name: String = "Build RestFul APis using Spring Boot and Kotlin",
    category: String = "Maarij",
) = CourseDto(
    id,
    name,
    category,
)
