package com.jopp.functionalkotlin.exchangedata.controller

import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeResponse
import com.jopp.functionalkotlin.exchangedata.service.ExchangeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExchangeDataController {

    @Autowired
    lateinit var exchangeService: ExchangeService

    @GetMapping("/exchange")
    fun getLatestExchangeData(): ResponseEntity<ExchangeResponse> {
        val response = exchangeService.fetchExchangeData()
        return ResponseEntity(response, HttpStatus.OK)
    }
}