package com.example.msaUser.domain.repository

import com.example.msaUser.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}