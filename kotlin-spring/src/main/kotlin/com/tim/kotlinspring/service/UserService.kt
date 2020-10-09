package com.tim.kotlinspring.service

import com.tim.kotlinspring.dto.UserDto
import com.tim.kotlinspring.entity.Authority
import com.tim.kotlinspring.entity.User
import com.tim.kotlinspring.logging.Logging
import com.tim.kotlinspring.repository.AuthorityRepository
import com.tim.kotlinspring.repository.UserRepository
import com.tim.kotlinspring.security.USER
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(private val userRepository: UserRepository,
                  private val authorityRepository: AuthorityRepository,
                  private val passwordEncoder: PasswordEncoder
) : Logging {

    fun registerUser(user: UserDto, password: String): User {
        log().info("do registerUser: $user")
        val encryptedPassword = passwordEncoder.encode(password)
        val authorities = mutableSetOf<Authority>()
        authorityRepository.findById(USER).ifPresent { authorities.add(it) }

        val newUser = User(
                password = encryptedPassword,
                username = user.username,
                email = user.email?.toLowerCase(),
                createdBy = user.username,
                lastModifiedBy = user.username,
                authorities = user.authorities?.let { authorities ->
                    authorities.map { authorityRepository.findById(it) }
                            .filter { it.isPresent }
                            .mapTo(mutableSetOf()) { it.get() }
                } ?: mutableSetOf()
        )
        userRepository.save(newUser)
        log().info("Created Information for User: $newUser")
        return newUser
    }

    fun findByUsername(username: String): User = userRepository.findByUsername(username).orElseThrow {
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "this user doesn't exist")
    }

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

