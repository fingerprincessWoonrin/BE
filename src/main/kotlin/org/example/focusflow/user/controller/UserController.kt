package org.example.focusflow.user.controller

import org.example.focusflow.user.dto.LoginRequest
import org.example.focusflow.user.dto.UserRequest
import org.example.focusflow.user.entity.User
import org.example.focusflow.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/focusflow/user")
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody userRequest: UserRequest): User {
        println(userRequest)
        return userService.registerUser(userRequest.userName, userRequest.password, userRequest.email)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody loginRequest: LoginRequest): User? {
        return userService.loginUser(loginRequest.userName, loginRequest.password)
    }
}