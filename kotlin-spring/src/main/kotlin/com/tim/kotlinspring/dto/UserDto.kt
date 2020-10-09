package com.tim.kotlinspring.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tim.kotlinspring.entity.Authority
import org.hibernate.annotations.BatchSize
import java.time.Instant
import javax.persistence.*

data class UserDto (
    var username: String,
    var password: String,
    var email: String? = null,
    var authorities: Set<String>? = null,
    var createdBy: String? = null,
    var lastModifiedBy: String? = null
)