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
//    private val EXCHANGE_CLIENT_API_KEY_PARAMETER = "api_token"
//    private val EXCHANGE_CLIENT_BASE_PARAMETER = "base"

    @BeforeAll
    fun setUp() {
        RestAssured.port = port
    }

    @Test
    fun testWeReturnLatestStockData() {

//        val urlExtension = "?$EXCHANGE_CLIENT_BASE_PARAMETER=GBP&$EXCHANGE_CLIENT_API_KEY_PARAMETER=$exchangeClientApiKey"
        val baseCurrency = "USD"
        val parameterisedUrl = "$getExchangeDataUrl/$baseCurrency"

        stubExchangeDataClientOk(baseCurrency)

        given().
                contentType("application/json").
        When().
                get(parameterisedUrl).
        then().
                statusCode(200).
                body("base", equalTo("USD"),
                        "data.aed", equalTo("3.672900"),
                        "data.afn", equalTo("77.300000"))
    }

    @Test
    fun testWeThrowExceptionWhenTheClientReturnsError() {

        val baseCurrency = "GBP"
        val parameterisedUrl = "$getExchangeDataUrl/$baseCurrency"

        stubExchangeDataClientDown()

        given().
                contentType("application/json").
        When().
                get(parameterisedUrl).
        then().
                statusCode(500).
                body("status", equalTo(500),
                        "message", equalTo("Call to exchange rates client failed"))
    }
}
