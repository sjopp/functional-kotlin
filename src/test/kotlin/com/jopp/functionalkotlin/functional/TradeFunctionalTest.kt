package com.jopp.functionalkotlin.functional

import io.restassured.RestAssured
import io.restassured.RestAssured.*
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
class TradeFunctionalTest: FunctionalTest() {

    private val getTradesUrl = "/trades"

    @LocalServerPort
    private val port: Int = 0

    @Before
    fun setUp() {
        RestAssured.port = port
//        RestAssured.config =
    }

    @Test
    fun testWeReturnAllTradesFromController() {

        given().
                contentType("application/json").
        When().
                get(getTradesUrl).
        then().
                statusCode(200)
//        and().
//                body("trades[0].volume", equalTo(100))
//                body(equalTo(""))
    }
}