package com.jopp.functionalkotlin.exchangedata.client

import com.jopp.functionalkotlin.exchangedata.exception.ExchangeClientException
import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestOperations

@Component
class ExchangeDataClient(val restTemplate: RestOperations) {

    @Value("\${exchange.url}")
    private val exchangeClientBaseUrl: String = ""

    @Value("\${exchange.api-key}")
    private val exchangeClientApiKey: String = ""

    fun getExchangeData(baseCurrency: String): ExchangeResponse {
        
        val parameterisedUrl = parametriseUrl(exchangeClientBaseUrl, baseCurrency)
        val response: ResponseEntity<ExchangeResponse>

        try {
            response = restTemplate.getForEntity<ExchangeResponse>(parameterisedUrl, ExchangeResponse::class.java)
        } catch (e: RestClientException) {
            throw ExchangeClientException("Call to exchange rates client failed")
        }

        return response.body?: throw ExchangeClientException("Response from Exchange Client did not have body")
    }

    private fun parametriseUrl(baseUrl: String, baseCurrency: String): String {
        return "$baseUrl?base=$baseCurrency&api_token=$exchangeClientApiKey"
    }
}
