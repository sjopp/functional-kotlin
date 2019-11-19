package com.jopp.functionalkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FunctionalKotlinApplication

fun main(args: Array<String>) {
    runApplication<FunctionalKotlinApplication>(*args)
}
