package com.jopp.functionalkotlin.exchangedata.service

import com.jopp.functionalkotlin.exchangedata.client.ExchangeDataClient
import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExchangeService {

    @Autowired
    lateinit var exchangeDataClient: ExchangeDataClient

    fun fetchExchangeData(baseCurrency: String): ExchangeResponse {
        return exchangeDataClient.getExchangeData(baseCurrency)
    }
}
