package com.tim.kotlinspring.service

import com.tim.kotlinspring.entity.User
import com.tim.kotlinspring.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(val userRepository: UserRepository) {

    fun findByUsername(username: String): List<User> = userRepository.findByUsername(username)

    fun create(user: User) = userRepository.save(user)

    fun save(user: User): User {
        val id = user.id ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "user id is null!")

        return userRepository.findById(id).orElseThrow {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "this user doesn't exist")
        }.apply {
            this.username = user.username
            this.password = user.password
            this.email = user.email
            userRepository.save(this)
        }
    }

    fun delete(id: Long) = userRepository.deleteById(id)

    fun findByEmailAndFilter(email: String): List<String?> {
        return userRepository.findByEmail(email)
                .map { it.email }
                .filter { it?.startsWith("t") ?: false }
    }
}

