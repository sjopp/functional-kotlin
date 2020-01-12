package com.jopp.functionalkotlin.trades.io

import java.math.BigDecimal

data class TradeRequest(val stock: String, val price: BigDecimal, val volume: Int)