package com.frs.console.service

import com.frs.console.domain.person.Person

interface PersonService {
    suspend fun findPerson(personId: Int): Person?
}