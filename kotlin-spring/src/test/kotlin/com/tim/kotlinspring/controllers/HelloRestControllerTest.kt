package com.tim.kotlinspring.controllers

import org.junit.jupiter.api.Test


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(HelloRestController::class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class HelloRestControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    internal fun `check hello`() {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/hello")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("hello kotlin with spring"))

    }

    @Test
    internal fun `check hello with Kotlin DSL`() {
        mockMvc.get("/api/hello") {
            accept = MediaType.APPLICATION_JSON
        }
                .andDo { print() }
                .andExpect {
                    status { isOk }
                    content { string("hello kotlin with spring") }
                }
    }

}