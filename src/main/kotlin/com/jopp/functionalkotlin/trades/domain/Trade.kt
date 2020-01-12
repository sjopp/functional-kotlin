package com.jopp.functionalkotlin.trades.domain

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document
data class Trade(val volume: Int,
                 val price: BigDecimal,
                 val stock: String,
                 val dateTime: String)