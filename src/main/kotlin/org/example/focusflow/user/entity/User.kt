package org.example.focusflow.user.entity

import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    val id: Long = 0,

    @Column(name = "userName")
    val userName: String,
    val password: String,
    val email: String
)