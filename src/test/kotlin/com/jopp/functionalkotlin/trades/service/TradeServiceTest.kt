package com.jopp.functionalkotlin.trades.service

import com.jopp.functionalkotlin.trades.dao.TradesDAO
import com.jopp.functionalkotlin.trades.domain.Trade
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigDecimal

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TradeServiceTest {

    @MockK
    lateinit var tradesDAO: TradesDAO

    @InjectMockKs
    private var tradeService = TradeService()

    @BeforeAll
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testWeCanGetAllTradesFromRepository() {
        every { tradesDAO.findAll() } returns defaultTradeList()
        val allTrades = tradeService.getAllTrades()
        assertThat(allTrades[0], equalTo(Trade(100, BigDecimal(100), "AAPL", "2019-11-24 18:36:00.000")))
    }

    @Test
    fun testWeCanSaveToRepository() {

//        tradeService.saveTrade(TradeRequest("ALPH", BigDecimal(236.00), 250))
    }

    private fun defaultTradeList(): List<Trade> {
        return listOf(Trade(100, BigDecimal(100), "AAPL", "2019-11-24 18:36:00.000"))
    }

}
