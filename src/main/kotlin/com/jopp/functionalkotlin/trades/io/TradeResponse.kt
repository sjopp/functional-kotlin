package com.jopp.functionalkotlin.trades.io

import com.jopp.functionalkotlin.trades.domain.Trade

data class TradeResponse(val trades: List<Trade>) {
}