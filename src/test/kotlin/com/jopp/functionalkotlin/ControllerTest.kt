package com.jopp.functionalkotlin

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class ControllerTest {

    private val tradeController = TradeController()

    @Test
    fun testWeReturnATrade() {
        val trades = tradeController.getTrades()
        assertThat(trades, equalTo(emptyList()))
    }
}