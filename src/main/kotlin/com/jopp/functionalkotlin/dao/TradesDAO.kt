package com.jopp.functionalkotlin.dao

import com.jopp.functionalkotlin.domain.Trade
import org.springframework.data.mongodb.repository.MongoRepository

interface TradesDAO: MongoRepository<Trade, String> {}