package com.example.coursecatalogservice.controller


import com.example.coursecatalogservice.dto.CourseDto
import com.example.coursecatalogservice.entity.Course
import com.example.coursecatalogservice.service.CourseService
import com.example.coursecatalogservice.util.CourseDto
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [CourseController::class])
@AutoConfigureWebTestClient
class CourseControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseServiceMock: CourseService

    @Test
    fun addCourse() {
        val courseDto = CourseDto()

        every { courseServiceMock.addCourse(any()) } returns CourseDto(id = 1)

        val savedCourseDto = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDto)
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
    fun addCourse_validation() {
        val courseDto = CourseDto(name="", category = "")

        every { courseServiceMock.addCourse(any()) } returns CourseDto(id = 1)

        webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDto)
            .exchange()
            .expectStatus().isBadRequest
    }

    @Test
    fun retrieveAllCourses(){
        every { courseServiceMock.retrieveAllCourses() }.returnsMany(
            listOf(CourseDto(id = 1),
                CourseDto(id = 2,
                    name = "Build Reactive Microservices using Spring WebFlux/SpringBoot"))
        )

        val CourseDtos = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDto::class.java)
            .returnResult()
            .responseBody

        println("CourseDtos : $CourseDtos")
        Assertions.assertEquals(2, CourseDtos!!.size)
    }

    @Test
    fun updateCourse(){
        val updatedCourseDto = Course(null,
            "Build RestFul APis using SpringBoot and Kotlin",
            "Development")

        every { courseServiceMock.updateCourse(any(), any()) } returns CourseDto(id=100,
            name = "Build RestFul APis using SpringBoot and Kotlin1")

        val updatedCourse = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", 100)
            .bodyValue(updatedCourseDto)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDto::class.java)
            .returnResult()
            .responseBody

        assertEquals("Build RestFul APis using SpringBoot and Kotlin1", updatedCourse!!.name)
    }

    @Test
    fun deleteCourse(){
        every { courseServiceMock.deleteCourse(any()) } just runs

        webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", 100)
            .exchange()
            .expectStatus().isNoContent

        verify(exactly = 1) { courseServiceMock.deleteCourse(any()) }
    }
}