package com.frs.console.service

import com.frs.console.domain.user.User

interface UserService {
    fun findUser(userId: String): User
}