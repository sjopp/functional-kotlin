package com.jopp.functionalkotlin

import com.jopp.functionalkotlin.controller.TradeController
import com.jopp.functionalkotlin.dao.TradesDAO
import com.jopp.functionalkotlin.domain.Trade
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigDecimal

//@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerTest {

    @MockK
    lateinit var tradesDAO: TradesDAO

    @InjectMockKs
    private var tradeController = TradeController()

    @BeforeAll
    internal fun beforeAll() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testWeReturnATrade() {
        every { tradesDAO.findAll() } returns defaultTradeList()
        val actualTrades = tradeController.getTrades()
        assertThat(actualTrades[0], equalTo(Trade( 100, BigDecimal(100), "AAPL", "2019-11-24 18:36:00.000")))
    }

    private fun defaultTradeList(): List<Trade> {
        return listOf(Trade(100, BigDecimal(100), "AAPL", "2019-11-24 18:36:00.000"))
    }
}