package com.frs.console.repository

import com.frs.console.config.TestH2DbConfig
import com.frs.console.domain.person.Person
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
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
    }

    @Test
    fun `find person`() {
        runBlocking {
            val name = "person"
            val person = savePerson(name)
            val findPerson = personRepository
                    .findById(person.id ?: 0)
            assertEquals(name, findPerson?.name)
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
            val findPerson   = personRepository
                    .findById(person.id ?: 0)
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
            val findPerson = personRepository
                    .findById(person.id ?: 0)
            assertTrue(findPerson == null)
        }
    }

    @Test
    fun `find roleKey test`() {
        runBlocking {
            val personList = personRepository
                    .findByRoleKey("ADMIN")
                    .toList()
            assertTrue(personList
                    .filter { it.name == "tester" }
                    .size == 1
            )
        }
    }
}