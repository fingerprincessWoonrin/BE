package org.example.focusflow.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val userID: Long? = null,

        val userName: String,
        val password: String,
        val email: String
)