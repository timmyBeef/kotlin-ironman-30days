package com.tim.kotlinspring.repository

import com.tim.kotlinspring.entity.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository : JpaRepository<User, Long> {

    fun findByUsername(username: String): List<User>

    fun findByEmail(email: String): List<User>


}