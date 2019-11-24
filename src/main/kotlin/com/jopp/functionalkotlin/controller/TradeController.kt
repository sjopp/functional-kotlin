package com.jopp.functionalkotlin.controller

import com.jopp.functionalkotlin.domain.Trade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class TradeController {

//    @GetMapping("/trades")
    fun getTrades(): List<Trade> {
        val trade = Trade(100, BigDecimal(100), "AAPL")
        return listOf(trade)
    }
}