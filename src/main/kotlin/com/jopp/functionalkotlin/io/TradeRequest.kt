package com.jopp.functionalkotlin.io

import java.math.BigDecimal

data class TradeRequest(val stock: String, val price: BigDecimal, val volume: Int)