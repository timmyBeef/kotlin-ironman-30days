package com.tim.kotlinspring.controllers

import com.tim.kotlinspring.entity.User
import com.tim.kotlinspring.repository.UserRepository
import com.tim.kotlinspring.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserRestController(val service: UserService) {

    @GetMapping("/{username}")
    fun findByUsername(@PathVariable username: String): ResponseEntity<List<User>> =
            ResponseEntity.ok(service.findByUsername(username))

    @PostMapping("/create")
    fun createUser(@RequestBody user: User): ResponseEntity<*> =
            ResponseEntity.ok(service.create(user));

    @PutMapping()
    fun saveUser(@RequestBody user: User): ResponseEntity<*> =
            ResponseEntity.ok(service.save(user));

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<*> =
            ResponseEntity.ok(service.delete(id))

    @PostMapping("/query/email")
    fun findByEmail(@RequestBody request: UserRequest): ResponseEntity<*> =
            ResponseEntity.ok(service.findByEmailAndFilter(request.email))

}

data class UserRequest(val email: String)