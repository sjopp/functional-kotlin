package com.jopp.functionalkotlin.exchangedata.client

import com.jopp.functionalkotlin.exchangedata.exception.ExchangeClientException
import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import java.util.*
import java.util.Collections.singletonList

@Component
class ExchangeDataClient {

    @Value("\${exchange.url}")
    private val exchangeClientUrl: String = ""

    val restTemplate = RestTemplate()

    fun getExchangeData(): ExchangeResponse {
        initialiseRestTemplate()
        val response: ResponseEntity<ExchangeResponse>

        try {
            response = restTemplate.getForEntity<ExchangeResponse>(exchangeClientUrl, ExchangeResponse::class.java)
        } catch (e: RestClientException) {
            throw ExchangeClientException("Call to exchange rates client failed")
        }

        return response.body?: throw ExchangeClientException("Response from Exchange Client did not have body")
    }

    private fun initialiseRestTemplate() {
        val messageConverters: MutableList<HttpMessageConverter<*>> = ArrayList()
        val converter = MappingJackson2HttpMessageConverter()
        converter.supportedMediaTypes = singletonList(MediaType.ALL)
        messageConverters.add(converter)
        restTemplate.messageConverters = messageConverters
    }
}
