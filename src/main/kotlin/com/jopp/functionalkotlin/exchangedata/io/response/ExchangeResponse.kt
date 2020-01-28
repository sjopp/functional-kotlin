package com.jopp.functionalkotlin.exchangedata.io.response

data class ExchangeResponse(val symbols_returned: Int, val base: String, val data: ExchangeData)