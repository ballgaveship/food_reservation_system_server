package com.frs.console.repository

import com.frs.console.domain.person.Person
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface PersonRepository : ReactiveCrudRepository<Person, Int> {
    @Query("select p.* from person p where p.name=:name")
    fun findByName(name: String): Mono<Person>
}