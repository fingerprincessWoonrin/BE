package org.example.focusflow.domain.user.repository


import org.example.focusflow.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String): User?
}