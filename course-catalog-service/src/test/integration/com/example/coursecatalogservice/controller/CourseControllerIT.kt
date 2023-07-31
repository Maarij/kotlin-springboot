package com.example.coursecatalogservice.controller

import com.example.coursecatalogservice.dto.CourseDto
import com.example.coursecatalogservice.entity.Course
import com.example.coursecatalogservice.repository.CourseRepository
import com.example.coursecatalogservice.util.courseEntityList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerIT {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setup() {
        courseRepository.deleteAll()
        val courses = courseEntityList()
        courseRepository.saveAll(courses)
    }

    @Test
    fun addCourse() {
        val CourseDto = CourseDto(null, "Build Restful APIs", "Maarij")

        val savedCourseDto = webTestClient.post()
            .uri("/v1/courses")
            .bodyValue(CourseDto)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDto::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            savedCourseDto!!.id != null
        }
    }

    @Test
    fun retrieveAllCourses() {
        val CourseDtos = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDto::class.java)
            .returnResult()
            .responseBody

        assertEquals(3, CourseDtos!!.size)
    }

    @Test
    fun updateCourse(){
        //existing course
        val course = Course(null,
            "Build RestFul APis using SpringBoot and Kotlin", "Development")
        courseRepository.save(course)

        //Updated CourseDto
        val updatedCourseDto = CourseDto(null,
            "Build RestFul APis using SpringBoot and Kotlin1", "Development")


        val updatedCourse = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", course.id)
            .bodyValue(updatedCourseDto)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDto::class.java)
            .returnResult()
            .responseBody

        assertEquals("Build RestFul APis using SpringBoot and Kotlin1", updatedCourse!!.name)
    }

    @Test
    fun deleteCourseCourse(){
        //existing course
        val course = Course(null,
            "Build RestFul APis using SpringBoot and Kotlin", "Development")
        courseRepository.save(course)

        //Updated CourseDto
        val updatedCourseDto = CourseDto(null,
            "Build RestFul APis using SpringBoot and Kotlin1", "Development")


        val updatedCourse = webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", course.id)
            .exchange()
            .expectStatus().isNoContent
    }
}