package com.frs.console.repository

import com.frs.console.domain.person.Person
import kotlinx.coroutines.flow.Flow

interface CustomPersonRepository {
    fun findByRoleKey(key: String): Flow<Person>
}