package org.example.focusflow.user.dto

import org.springframework.data.relational.core.mapping.Column

data class UserRequest(


    val userName: String,
    val password: String,
    val email: String
)