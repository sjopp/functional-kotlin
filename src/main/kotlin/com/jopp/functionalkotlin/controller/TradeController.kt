package com.jopp.functionalkotlin.controller

import com.jopp.functionalkotlin.dao.TradesDAO
import com.jopp.functionalkotlin.domain.Trade
import com.jopp.functionalkotlin.io.TradeRequest
import com.jopp.functionalkotlin.io.TradeResponse
import com.jopp.functionalkotlin.service.TradeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

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