package org.example.focusflow.user.repository

import org.example.focusflow.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String): User?
}