package com.frs.console.service.impl

import com.frs.console.domain.user.User
import com.frs.console.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    override fun findUser(userId: String): User {
        return User(userId)
    }
}