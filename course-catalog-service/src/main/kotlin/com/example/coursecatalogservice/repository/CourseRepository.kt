package com.example.coursecatalogservice.repository

import com.example.coursecatalogservice.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int>