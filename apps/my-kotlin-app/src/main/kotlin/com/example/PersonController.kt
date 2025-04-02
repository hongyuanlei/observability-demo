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
    private val personHelloCounter: LongCounter
) {

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/{id}"],
        produces = ["application/json"]
    )
    fun person(@PathVariable("id") id: String): ResponseEntity<Person> {
        LOG.info("Retrieving person information for id: $id")
        personHelloCounter.add(
            1, Attributes.of(
                AttributeKey.stringKey("id"), id,
                AttributeKey.stringKey("name"), "hello $id"
            )
        )
        return ResponseEntity(Person(id, "Hello $id"), HttpStatus.OK)
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(PersonController::class.java)
    }
}