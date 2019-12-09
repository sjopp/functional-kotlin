package com.jopp.functionalkotlin.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document
data class Trade(val volume: Int,
                 val price: BigDecimal,
                 val stock: String,
                 val dateTime: String)