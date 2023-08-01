package com.example.coursecatalogservice.dto

import jakarta.validation.constraints.NotBlank

data class CourseDto(
    val id: Int?,
    @get:NotBlank(message = "CourseDto.name must not be blank")
    val name: String,
    @get:NotBlank(message = "CourseDto.category must not be blank")
    val category: String
)