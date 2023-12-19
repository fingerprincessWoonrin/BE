package org.example.focusflow.domain.user.entity

import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userID: Long?,
    val userName: String?,
    val password: String?,
    val email: String?
)