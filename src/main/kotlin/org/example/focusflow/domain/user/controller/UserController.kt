package org.example.focusflow.domain.user.controller

import org.example.focusflow.domain.user.entity.User
import org.example.focusflow.domain.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/focusflow/user")
class UserController @Autowired constructor(private val userService: UserService) {

    @GetMapping("")
    fun serverConnectTest(): String {
        return "server connected"
    }
    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): User {
        return userService.registerUser(user)
    }

    @PostMapping("/login")
    fun loginUser(@RequestParam userName: String, @RequestParam password: String): Boolean {
        return userService.loginUser(userName, password)
    }
}