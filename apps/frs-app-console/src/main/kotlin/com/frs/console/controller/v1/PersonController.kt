package com.frs.console.controller.v1

import com.frs.console.domain.person.Person
import com.frs.console.service.PersonService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("frs/v1/persons")
class PersonController(
        val personService: PersonService
) {
    @GetMapping("/{personId}")
    suspend fun getPerson(@PathVariable personId: Int): ResponseEntity<Person> {
        val user = personService.findPerson(personId)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
    }
}