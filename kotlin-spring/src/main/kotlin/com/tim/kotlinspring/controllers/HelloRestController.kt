package com.tim.kotlinspring.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloRestController {
    @GetMapping("/hello")
    fun hello() = "hello kotlin with spring"
}