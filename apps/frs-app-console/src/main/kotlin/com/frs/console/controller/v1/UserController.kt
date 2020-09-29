package com.frs.console.controller.v1

import com.frs.console.domain.user.User
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("frs/v1/users")
class UserController {
    @GetMapping("/{userId}")
    suspend fun getUser(@PathVariable userId: String): ResponseEntity<User> {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(User(userId))
    }
}