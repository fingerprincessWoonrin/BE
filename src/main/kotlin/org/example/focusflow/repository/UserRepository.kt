package org.example.focusflow.repository

import org.example.focusflow.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<UserEntity, Long> {
    fun findByUserName(userName:String): UserEntity?
    fun findByEmail(email:String): UserEntity?
}