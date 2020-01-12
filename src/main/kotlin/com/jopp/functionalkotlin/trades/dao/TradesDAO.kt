package com.jopp.functionalkotlin.trades.dao

import com.jopp.functionalkotlin.trades.domain.Trade
import org.springframework.data.mongodb.repository.MongoRepository

interface TradesDAO: MongoRepository<Trade, String> {}