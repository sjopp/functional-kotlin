package com.jopp.functionalkotlin.trades.controller

import com.jopp.functionalkotlin.trades.io.TradeRequest
import com.jopp.functionalkotlin.trades.io.TradeResponse
import com.jopp.functionalkotlin.trades.service.TradeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TradeController {

    @Autowired
    lateinit var tradeService: TradeService

    @GetMapping("/trades")
    fun getTrades(): ResponseEntity<TradeResponse> {
        val response = TradeResponse(tradeService.getAllTrades())
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping("/trade")
    fun addTrade(@RequestBody request: TradeRequest): ResponseEntity<String> {
        tradeService.saveTrade(request)
        return ResponseEntity("", HttpStatus.CREATED)
    }
}