package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class MyKotlinApplication

fun main(args: Array<String>) {
    runApplication<MyKotlinApplication>(*args)
}