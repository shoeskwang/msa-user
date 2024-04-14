package com.example.msaUser.api

import com.example.msaUser.application.UserService
import com.example.msaUser.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @PostMapping
    fun addUser(@RequestBody request: User): User {
        return userService.createUser(request)
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId: Long): User? {
        return userService.getUserById(userId)
    }
}