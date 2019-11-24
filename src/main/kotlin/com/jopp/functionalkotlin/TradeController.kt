package com.jopp.functionalkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TradeController {

//    @GetMapping("/trades")
    fun getTrades(): List<String> {
        return emptyList()
    }
}