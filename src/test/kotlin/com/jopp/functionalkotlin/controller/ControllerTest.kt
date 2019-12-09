package com.jopp.functionalkotlin.controller

import com.jopp.functionalkotlin.dao.TradesDAO
import com.jopp.functionalkotlin.domain.Trade
import com.jopp.functionalkotlin.io.TradeRequest
import com.jopp.functionalkotlin.service.TradeService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.mockito.Mockito.times
import java.math.BigDecimal
import kotlin.test.Ignore

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerTest {

    @MockK
    lateinit var tradeService: TradeService

    @InjectMockKs
    private var tradeController = TradeController()

    @BeforeAll
    internal fun beforeAll() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testWeReturnATrade() {
        every { tradeService.getAllTrades() } returns defaultTradeList()
        val actualTrades = tradeController.getTrades()
        assertThat(actualTrades.body?.trades?.get(0), equalTo(Trade( 100, BigDecimal(100), "AAPL", "2019-11-24 18:36:00.000")))
    }


//    @Test
//    @Ignore("Not working with verify")
//    fun testWeSaveATrade() {
//        val tradeRequest = TradeRequest("GOOG", BigDecimal("41.04"), 250)
//        every { tradeService.saveTrade(tradeRequest) } returns Unit
//        tradeController.addTrade(tradeRequest)
//        Mockito.verify(tradeService).saveTrade(tradeRequest)
//    }

    private fun defaultTradeList(): List<Trade> {
        return listOf(Trade(100, BigDecimal(100), "AAPL", "2019-11-24 18:36:00.000"))
    }
}