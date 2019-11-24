package com.jopp.functionalkotlin.domain

import java.math.BigDecimal

data class Trade(val volume: Int, val price: BigDecimal, val stock: String) {}