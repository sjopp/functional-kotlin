package com.jopp.functionalkotlin.controller

import com.jopp.functionalkotlin.dao.TradesDAO
import com.jopp.functionalkotlin.domain.Trade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class TradeController {

    @Autowired
    lateinit var tradeRepository: TradesDAO

    @GetMapping("/trades")
    fun getTrades(): List<Trade> {
        return tradeRepository.findAll()
    }
}