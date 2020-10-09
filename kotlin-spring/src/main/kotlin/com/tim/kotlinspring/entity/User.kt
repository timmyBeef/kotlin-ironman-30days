package com.tim.kotlinspring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.BatchSize
import java.time.Instant
import javax.persistence.*

@Entity
@Table
class User(
        var username: String,
        var password: String,
        var email: String? = null,

        @ManyToMany
        @JoinTable(
                name = "user_authority",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "authority_name", referencedColumnName = "name")]
        )
        @BatchSize(size = 20)
        var authorities: MutableSet<Authority> = mutableSetOf(),

        @Column(name = "created_by")
        var createdBy: String? = null,

        @Column(name = "created_date")
        var createdDate: Instant? = Instant.now(),

        @Column(name = "last_modified_by")
        var lastModifiedBy: String? = null,

        @Column(name = "last_modified_date")
        var lastModifiedDate: Instant? = Instant.now(),

        @Id @GeneratedValue var id: Long? = null) {

        override fun toString(): String {
                return "User(username='$username', password='$password', email=$email, authorities=$authorities, createdBy=$createdBy, createdDate=$createdDate, lastModifiedBy=$lastModifiedBy, lastModifiedDate=$lastModifiedDate, id=$id)"
        }
}

