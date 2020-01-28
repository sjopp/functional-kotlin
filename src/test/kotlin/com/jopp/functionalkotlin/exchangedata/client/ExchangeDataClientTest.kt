package com.jopp.functionalkotlin.exchangedata.client

import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeData
import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeResponse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.util.ReflectionTestUtils
import org.springframework.web.client.RestClientException
import kotlin.test.assertFailsWith

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExchangeDataClientTest {

    private var exchangeDataClient = ExchangeDataClient()

    @BeforeAll
    fun setUp() {
        ReflectionTestUtils.setField(exchangeDataClient, "exchangeClientBaseUrl", "http://base-url.com/api/")
        ReflectionTestUtils.setField(exchangeDataClient, "exchangeClientApiKey", "grebgiuFFBGJ95trjgjr")
    }

    @Test()
    fun testWeReturnExchangeDataResponse() {
//        assertFailsWith(RestClientException::class, exchangeDataClient.getExchangeData("GBP"))
    }

    private fun defaultResponse(): ResponseEntity<ExchangeResponse> {
        return ResponseEntity(ExchangeResponse(200, "GBP", ExchangeData()), HttpStatus.OK)
    }
}