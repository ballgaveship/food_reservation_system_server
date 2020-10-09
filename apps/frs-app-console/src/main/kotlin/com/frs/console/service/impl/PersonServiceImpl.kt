package com.frs.console.service.impl

import com.frs.console.domain.person.Person
import com.frs.console.repository.PersonRepository
import com.frs.console.service.PersonService
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(
        val personRepository: PersonRepository
) : PersonService {
    override suspend fun findPerson(personId: Int): Person {
        return personRepository.findById(personId)
                .awaitFirst()
//        return personRepository.findByName("tester")
//                .awaitFirst()
    }
}