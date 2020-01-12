package com.jopp.functionalkotlin.functional

import com.jopp.functionalkotlin.trades.dao.TradesDAO
import com.jopp.functionalkotlin.trades.domain.Trade
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.config.JsonConfig.jsonConfig
import io.restassured.config.RestAssuredConfig.newConfig
import io.restassured.path.json.config.JsonPathConfig
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TradeFunctionalTest: FunctionalTest() {

    private val getTradesUrl = "/trades"
    private val addTradesUrl = "/trade"

    @Autowired
    private lateinit var tradeRepository: TradesDAO

    @BeforeAll
    fun setUp() {
        tradeRepository.save(Trade(100, BigDecimal.TEN, "GOOG", "2019-25-11 20:03:01.000"))
        RestAssured.port = port
        RestAssured.config = newConfig().jsonConfig(jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL))
    }

    @Test
    fun testWeReturnAllTradesFromController() {

        given().
                contentType("application/json").
        When().
                get(getTradesUrl).
        then().
                statusCode(200).
        and().
                body("trades[0].volume", equalTo(100),
                        "trades[0].price", equalTo(10),
                        "trades[0].stock", equalTo("GOOG"),
                        "trades[0].dateTime", equalTo("2019-25-11 20:03:01.000"))
    }

    @Test
    fun testWeAddATradeToTheDatabase() {

        given().
                contentType("application/json").
                body(readFileContents("__files/database/trade-list.json")).
        When().
                post(addTradesUrl).
        then().
                statusCode(201)
    }
}
