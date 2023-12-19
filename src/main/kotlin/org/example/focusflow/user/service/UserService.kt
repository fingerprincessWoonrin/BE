package org.example.focusflow.user.service

import org.example.focusflow.user.entity.User
import org.example.focusflow.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun registerUser(userName: String, password: String, email: String): User {
        val user = User(userName = userName, password = password, email = email)
        return userRepository.save(user)
    }

    fun loginUser(userName: String, password: String): User? {
        val user = userRepository.findByUserName(userName)
        return if (user != null && user.password == password) {
            user
        } else {
            null
        }
    }
}