package com.frs.console.repository

import com.frs.console.domain.person.Person
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface PersonRepository : ReactiveSortingRepository<Person, Int> {
    fun findByName(name: String): Flux<Person>
}