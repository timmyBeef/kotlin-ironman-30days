package com.tim.kotlinspring.controllers

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.tim.kotlinspring.entity.User
import com.tim.kotlinspring.logging.Logging
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class UserRestControllerTest(@Autowired val restTemplate: TestRestTemplate): Logging {

    private val objectMapper = ObjectMapper()

    @Test
    internal fun `test findByUsername `() {
        val response = restTemplate.getForEntity<List<User>>("/api/user/tim")

        // 測試 200 ok
        assertEquals(HttpStatus.OK, response.statusCode)

        // 測試 header MediaType.APPLICATION_JSON
        response.headers.contentType?.let {
            assertTrue(it == MediaType.APPLICATION_JSON)
        } ?: fail("Content type header is not application/json")

        // 測試名字
        val userList: List<User>? = objectMapper.convertValue(
                response.body,
                object : TypeReference<List<User>>() {}
        )
        // val userList: List<User>? = response.body  // => not work
        log().info(userList.toString())

        assertEquals("tim", userList?.getOrNull(0)?.username)
    }

}