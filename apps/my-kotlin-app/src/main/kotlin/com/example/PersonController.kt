package com.example

import io.opentelemetry.api.common.AttributeKey
import io.opentelemetry.api.common.Attributes
import io.opentelemetry.api.metrics.LongCounter
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

data class Person(val id: String, val name: String)
@RestController
@RequestMapping("/api/v1/person")
class PersonController(
    private val personGetCounter: LongCounter
) {

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/{id}"],
        produces = ["application/json"]
    )
    fun getPerson(@PathVariable("id") id: String): ResponseEntity<Person> {
        LOG.info("Retrieving person information for id: $id")
        val person = Person(id, "Hello $id")

        // Adding OTEL custom metrics
        personGetCounter.add(
            1, Attributes.of(
                AttributeKey.stringKey("id"), person.id,
                AttributeKey.stringKey("name"), person.name
            )
        )

        return ResponseEntity(person, HttpStatus.OK)
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(PersonController::class.java)
    }
}