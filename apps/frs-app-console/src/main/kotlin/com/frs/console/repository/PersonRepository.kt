package com.frs.console.repository

import com.frs.console.domain.person.Person
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CoroutineSortingRepository<Person, Int> {
    fun findByName(name: String): Flow<Person>
}