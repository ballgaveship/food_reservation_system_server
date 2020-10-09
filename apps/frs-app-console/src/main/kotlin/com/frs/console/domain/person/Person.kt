package com.frs.console.domain.person

import org.springframework.data.annotation.Id

data class Person(
        @get:Id
        val id: Int,
        val name: String,
        val email: String
)