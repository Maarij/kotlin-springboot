package com.example.coursecatalogservice.controller

import com.example.coursecatalogservice.service.GreetingsService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingController(val greetingsService: GreetingsService) {

    companion object : KLogging()

    @GetMapping("/{name}")
    fun retrieveGreetings(@PathVariable name: String): String {
        logger.info("Name is $name")
        return greetingsService.retrieveGreeting(name)
    }
}