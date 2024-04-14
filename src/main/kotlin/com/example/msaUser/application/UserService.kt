package com.example.msaUser.application

import com.example.msaUser.domain.User

interface UserService {
    fun getAllUsers(): List<User>
    fun getUserById(id: Long): User?
    fun createUser(user: User): User
    fun updateUser(id: Long, user: User): User
    fun deleteUser(id: Long): Boolean
}