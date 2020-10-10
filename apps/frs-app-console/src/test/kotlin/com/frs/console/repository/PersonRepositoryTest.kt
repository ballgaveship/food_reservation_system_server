package com.frs.console.repository

import com.frs.console.config.TestH2DbConfig
import com.frs.console.domain.person.Person
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@ActiveProfiles("local")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest(classes = [TestH2DbConfig::class, PersonRepository::class])
class PersonRepositoryTest(private val personRepository: PersonRepository) {

    @Test
    fun `insert person`() {
        runBlocking {
            val name = "person"
            val person = savePerson(name)
            assertEquals(name, person.name)
        }
    }

    private suspend fun savePerson(name: String): Person {
        return personRepository
                .save(Person(
                        null,
                        name,
                        "$name@test.com"
                ))
                .awaitFirst()
    }

    @Test
    fun `find person`() {
        runBlocking {
            val name = "person"
            val person = savePerson(name)
            val findPerson = personRepository
                    .findById(person.id ?: 0)
                    .awaitSingle()
            assertEquals(name, findPerson.name)
        }
    }

    @Test
    fun `list persons`() {
        runBlocking {
            val name = "person"
            for (i in 1..2) {
                savePerson(name)
            }
            val personList = personRepository
                    .findByName(name)
                    .asFlow()
                    .toList()
            assertTrue(personList
                    .filter { it.name == "person" }
                    .size == 2
            )
        }
    }

    @Test
    fun `update person`() {
        runBlocking {
            val name = "person"
            val email = "test@test.com"
            val person = savePerson(name)
            val copiedPerson = person.copy(
                    email = email
            )
            personRepository
                    .save(copiedPerson)
                    .awaitFirst()
            val findPerson   = personRepository
                    .findById(person.id ?: 0)
                    .awaitFirstOrNull()
            assertEquals(email, findPerson?.email)
        }
    }

    @Test
    fun `delete person`() {
        runBlocking {
            val name = "person"
            val person = savePerson(name)
            personRepository
                    .deleteById(person.id ?: 0)
                    .subscribe()
            val findPerson = personRepository
                    .findById(person.id ?: 0)
                    .awaitFirstOrNull()
            assertTrue(findPerson == null)
        }
    }

    // TODO: check join table
}