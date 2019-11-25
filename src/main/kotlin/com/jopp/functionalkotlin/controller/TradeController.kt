package com.jopp.functionalkotlin.controller

import com.jopp.functionalkotlin.dao.TradesDAO
import com.jopp.functionalkotlin.domain.Trade
import com.jopp.functionalkotlin.io.TradeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class TradeController {

    @Autowired
    lateinit var tradeRepository: TradesDAO

    @GetMapping("/trades")
    fun getTrades(): ResponseEntity<TradeResponse> {
        val response = TradeResponse(tradeRepository.findAll())
        return ResponseEntity(response, HttpStatus.OK)
    }
}