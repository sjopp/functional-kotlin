package com.jopp.functionalkotlin.functional

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
class ExchangeDataFunctionalTest: FunctionalTest() {

    private val getExchangeDataUrl = "/exchange"

    @BeforeAll
    fun setUp() {
        RestAssured.port = port
    }

    @Test
    fun testWeReturnLatestStockData() {

        stubExchangeDataClientOk()

        given().
                contentType("application/json").
        When().
                get(getExchangeDataUrl).
        then().
                statusCode(200).
                body("base", equalTo("GBP"),
                        "data.aed", equalTo("4.798852"),
                        "data.afn", equalTo("101.473095"))
    }

    @Test
    fun testWeThrowExceptionWhenTheClientReturnsError() {

        stubExchangeDataClientDown()

        given().
                contentType("application/json").
        When().
                get(getExchangeDataUrl).
        then().
                statusCode(500).
                body("status", equalTo(500),
                        "message", equalTo("Call to exchange rates client failed"))
    }
}
