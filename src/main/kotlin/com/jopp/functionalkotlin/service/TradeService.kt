package com.jopp.functionalkotlin.service

import com.jopp.functionalkotlin.dao.TradesDAO
import com.jopp.functionalkotlin.domain.Trade
import com.jopp.functionalkotlin.io.TradeRequest
import io.netty.util.internal.SystemPropertyUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class TradeService {

    @Autowired
    lateinit var tradesDAO: TradesDAO

    fun getAllTrades(): List<Trade> {
        return tradesDAO.findAll()
    }

    fun saveTrade(tradeRequest: TradeRequest) {
        val trade = Trade(tradeRequest.volume, tradeRequest.price, tradeRequest.stock, LocalDateTime.now().toString())
        tradesDAO.save(trade)
    }
}