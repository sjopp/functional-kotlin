package com.jopp.functionalkotlin.exchangedata.exception

import com.jopp.functionalkotlin.exchangedata.io.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.RestClientException
import org.springframework.web.context.request.WebRequest
import java.util.*

@ControllerAdvice
class ExchangeExceptionHandler {

    @ExceptionHandler(value = [(ExchangeClientException::class), (RestClientException::class)])
    fun handleClientException(exception: ExchangeClientException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.message!!, Date().toString())
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}