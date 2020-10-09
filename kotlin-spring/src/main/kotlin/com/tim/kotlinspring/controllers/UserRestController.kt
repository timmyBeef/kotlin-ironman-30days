package com.tim.kotlinspring.controllers

import com.tim.kotlinspring.dto.UserDto
import com.tim.kotlinspring.entity.User
import com.tim.kotlinspring.repository.UserRepository
import com.tim.kotlinspring.security.ADMIN
import com.tim.kotlinspring.security.USER
import com.tim.kotlinspring.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserRestController(val service: UserService) {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerAccount(@RequestBody user: UserDto): User {

        return service.registerUser(user, user.password!!)
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAuthority(\"$ADMIN\")")
    fun findByUsername(@PathVariable username: String): ResponseEntity<User> =
            ResponseEntity.ok(service.findByUsername(username))

    @PutMapping()
    @PreAuthorize("hasAuthority(\"$ADMIN\")")
    fun saveUser(@RequestBody user: User): ResponseEntity<*> =
            ResponseEntity.ok(service.save(user));

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority(\"$ADMIN\")")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<*> =
            ResponseEntity.ok(service.delete(id))

    @PostMapping("/query/email")
    @PreAuthorize("hasAuthority(\"$USER\")")
    fun findByEmail(@RequestBody request: UserRequest): ResponseEntity<*> =
            ResponseEntity.ok(service.findByEmailAndFilter(request.email))

}

data class UserRequest(val email: String)
