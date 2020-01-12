package com.jopp.functionalkotlin.functional

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExchangeDataFunctionalTest: FunctionalTest() {

    private val getExchangeDataUrl = "/exchange"

    val wireMockServer =  WireMockServer()

    @BeforeAll
    fun setUp() {
        RestAssured.port = port
        wireMockServer.start()
    }

    @AfterAll
    fun tearDown() {
        wireMockServer.stop()
    }

    @Test
    fun testWeReturnLatestStockData() {

        stubFor(get(urlEqualTo("/api/v1/forex"))
                .willReturn(aResponse().
                                withBodyFile("/forex/base-gbp-data.json")))

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

        stubFor(get(urlEqualTo("/api/v1/forex"))
                .willReturn(aResponse().
                        withStatus(500)))

        given().
                contentType("application/json").
        When().
                get(getExchangeDataUrl).
        then().
                statusCode(500)
    }
}