package com.tim.kotlinspring.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class User(
        var username: String,
        var password: String,
        var email: String? = null,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = null) {

    override fun toString(): String {
        return "User(username='$username', password='$password', email=$email, id=$id)"
    }
}

