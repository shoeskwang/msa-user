package com.example.msaUser.application

import com.example.msaUser.domain.User
import com.example.msaUser.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun getUserById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }

    @Transactional
    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    @Transactional
    override fun updateUser(id: Long, user: User): User {
        val existingUser = userRepository.findById(id).orElseThrow {
            throw RuntimeException("User not found")
        }
        existingUser.name = user.name
        return userRepository.save(existingUser)
    }

    @Transactional
    override fun deleteUser(id: Long): Boolean {
        userRepository.deleteById(id)
        return true
    }
}