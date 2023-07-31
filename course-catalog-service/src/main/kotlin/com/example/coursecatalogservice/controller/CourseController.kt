package com.example.coursecatalogservice.controller

import com.example.coursecatalogservice.dto.CourseDto
import com.example.coursecatalogservice.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDTO: CourseDto): CourseDto {
        return courseService.addCourse(courseDTO)
    }

    @GetMapping
    fun retrieveAllCourses(): List<CourseDto> = courseService.retrieveAllCourses()

    @PutMapping("/{courseId}")
    fun updateCourse(@RequestBody courseDTO: CourseDto, @PathVariable courseId: Int) = courseService.updateCourse(courseId, courseDTO)

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCourse(@PathVariable courseId: Int) = courseService.deleteCourse(courseId)
}