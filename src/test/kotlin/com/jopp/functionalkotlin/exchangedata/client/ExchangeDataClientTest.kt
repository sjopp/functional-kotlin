package com.jopp.functionalkotlin.exchangedata.client

import com.jopp.functionalkotlin.exchangedata.exception.ExchangeClientException
import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeData
import com.jopp.functionalkotlin.exchangedata.io.response.ExchangeResponse
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.util.ReflectionTestUtils
import org.springframework.web.client.RestClientException
import kotlin.test.assertFailsWith

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExchangeDataClientTest {

    lateinit var exchangeDataClient: ExchangeDataClient
    lateinit var spyRestTemplate: SpyRestTemplate

    @BeforeAll
    fun setUp() {
        spyRestTemplate = SpyRestTemplate()
        exchangeDataClient = ExchangeDataClient(spyRestTemplate)
        ReflectionTestUtils.setField(exchangeDataClient, "exchangeClientBaseUrl", "http://base-url.com/api/")
        ReflectionTestUtils.setField(exchangeDataClient, "exchangeClientApiKey", "grebgiuFFBGJ95trjgjr")
    }

    @Test
    fun testWeReturnExchangeData() {

        spyRestTemplate.stubbedGet = exchangeResponse
        val exchangeData = exchangeDataClient.getExchangeData("GBP")
        assertThat(exchangeData.base, equalTo("GBP"))
    }

    // TODO: Fix this when understand how to get spy to throw exception
    @Test
    fun testWeThrowExceptionWhenNoResponseFromDownstream() {
//
//        assertFailsWith(ExchangeClientException::class) {
//            exchangeDataClient.getExchangeData("GBP")
//        }
    }

    private val exchangeResponse = """
        {
            "symbols_returned": 147,
            "base": "GBP",
            "data": {
                "AED": "3.673000",
                "AFN": "76.800000",
                "ALL": "111.475000",
                "AMD": "478.522100",
                "ANG": "1.645118",
                "AOA": "496.384000",
                "ARS": "60.158400",
                "AUD": "1.481245",
                "AWG": "1.800000",
                "AZN": "1.700000",
                "BAM": "1.776388",
                "BBD": "2.019228",
                "BCH": "0.002746",
                "BDT": "84.784220",
                "BGN": "1.776740",
                "BHD": "0.377009",
                "BIF": "1891.000000",
                "BMD": "1.000000",
                "BND": "1.358837",
                "BOB": "6.915346",
                "BRL": "4.199800",
                "BSD": "1.000077",
                "BTC": "0.000111",
                "BWP": "10.858340",
                "BZD": "2.015776",
                "CAD": "1.317935",
                "CDF": "1685.000000",
                "CHF": "0.973190",
                "CLF": "0.027763",
                "CLP": "786.700000",
                "CNY": "6.936700",
                "COP": "3386.480000",
                "CRC": "565.532700",
                "CUP": "0.999986",
                "CVE": "100.600000",
                "CZK": "22.894500",
                "DJF": "177.720000",
                "DKK": "6.785900",
                "DOP": "53.450000",
                "DZD": "120.143000",
                "EGP": "15.795900",
                "ETB": "32.200000",
                "ETH": "0.005854",
                "EUR": "0.908010",
                "FJD": "2.176500",
                "GBP": "0.769195",
                "GEL": "2.890000",
                "GHS": "5.580000",
                "GIP": "0.812880",
                "GMD": "51.150000",
                "GNF": "9415.000000",
                "GTQ": "7.665381",
                "GYD": "208.044400",
                "HKD": "7.776850",
                "HNL": "24.830000",
                "HRK": "6.755800",
                "HTG": "99.001370",
                "HUF": "306.904000",
                "IDR": "13647.000000",
                "ILS": "3.453900",
                "INR": "71.210500",
                "IQD": "1190.000000",
                "IRR": "42105.000000",
                "ISK": "124.270000",
                "JMD": "139.426800",
                "JOD": "0.709000",
                "JPY": "109.109500",
                "KES": "100.890000",
                "KGS": "69.850000",
                "KHR": "4060.000000",
                "KMF": "447.550000",
                "KRW": "1178.295000",
                "KWD": "0.303860",
                "KYD": "0.833413",
                "KZT": "380.794100",
                "LAK": "8895.000000",
                "LBP": "1511.834000",
                "LKR": "181.509100",
                "LRD": "195.000000",
                "LSL": "14.600000",
                "LTC": "0.017185",
                "LYD": "1.405000",
                "MAD": "9.660000",
                "MDL": "17.576420",
                "MGA": "3635.000000",
                "MKD": "55.857550",
                "MMK": "1465.073000",
                "MOP": "8.012243",
                "MRO": "0.000000",
                "MUR": "36.846650",
                "MVR": "15.450000",
                "MWK": "740.000000",
                "MXN": "18.762830",
                "MYR": "4.086300",
                "MZN": "63.605000",
                "NAD": "14.600000",
                "NGN": "361.500000",
                "NIO": "34.280000",
                "NOK": "9.128800",
                "NPR": "114.104700",
                "NZD": "1.530990",
                "OMR": "0.385001",
                "PAB": "1.000077",
                "PEN": "3.337000",
                "PGK": "3.380000",
                "PHP": "50.735500",
                "PKR": "154.550000",
                "PLN": "3.878950",
                "PYG": "6520.983000",
                "QAR": "3.641000",
                "RON": "4.340500",
                "RSD": "106.750000",
                "RUB": "62.375000",
                "RWF": "940.000000",
                "SAR": "3.751607",
                "SBD": "8.294155",
                "SCR": "13.700800",
                "SDG": "45.300000",
                "SEK": "9.618500",
                "SGD": "1.358900",
                "SLL": "9725.000000",
                "SOS": "582.500000",
                "SRD": "7.458000",
                "SVC": "8.751016",
                "SZL": "14.600000",
                "THB": "30.810000",
                "TJS": "9.695508",
                "TMT": "3.500000",
                "TND": "2.835500",
                "TOP": "2.307400",
                "TRY": "5.941050",
                "TTD": "6.762033",
                "TWD": "30.117500",
                "TZS": "2310.114000",
                "UAH": "24.746260",
                "UGX": "3678.152000",
                "UYU": "37.216570",
                "UZS": "9568.000000",
                "VEF": "0.000000",
                "VND": "23172.500000",
                "XAF": "595.774800",
                "XCD": "2.702550",
                "XOF": "596.000000",
                "XPF": "108.950000",
                "YER": "250.350000",
                "ZAR": "14.580950",
                "ZMW": "14.585720"
            }
        }
    """.trimIndent()

    private val badResponse = """
        {
            "message": "Invalid API Key."
        }
    """.trimIndent()
}