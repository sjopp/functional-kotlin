package com.jopp.functionalkotlin.trades.service

import com.jopp.functionalkotlin.trades.dao.TradesDAO
import com.jopp.functionalkotlin.trades.domain.Trade
import com.jopp.functionalkotlin.trades.io.TradeRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

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