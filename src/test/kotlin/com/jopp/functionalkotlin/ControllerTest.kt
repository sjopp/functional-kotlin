package com.jopp.functionalkotlin

import com.jopp.functionalkotlin.controller.TradeController
import com.jopp.functionalkotlin.domain.Trade
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ControllerTest {

    private val tradeController = TradeController()

    @Test
    fun testWeReturnATrade() {
        val generateTrades = defaultTradeList()
        val trades = tradeController.getTrades()
        assertThat(trades[0], equalTo(generateTrades[0]))
    }

    private fun defaultTradeList(): List<Trade> {
        return listOf(Trade(100, BigDecimal(100), "AAPL"))
    }
}