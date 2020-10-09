package com.tim.kotlinspring.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table
class Authority(
        @Id var name: String? = null
) : Serializable
