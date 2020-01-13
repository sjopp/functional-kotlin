package com.jopp.functionalkotlin.functional

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import io.restassured.specification.RequestSpecification
import org.apache.commons.io.IOUtils
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.junit4.SpringRunner
import java.nio.charset.Charset

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class FunctionalTest {

    private val wireMockServer =  WireMockServer()

    @LocalServerPort
    protected val port: Int = 0

    @BeforeAll
    fun setUpMocks() {
        wireMockServer.start()
    }

    @AfterAll
    fun tearDown() {
        wireMockServer.stop()
    }

    protected fun RequestSpecification.When(): RequestSpecification {
        return this.`when`()
    }

    protected fun readFileContents(testFixture: String): String {
        val resource = ClassPathResource(testFixture).inputStream
        return IOUtils.toString(resource, Charset.defaultCharset())
    }

    protected fun stubExchangeDataClientOk() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/v1/forex"))
                .willReturn(WireMock.aResponse().withBodyFile("/forex/base-gbp-data.json")))
    }

    protected fun stubExchangeDataClientDown() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/v1/forex"))
                .willReturn(WireMock.aResponse().withStatus(500)))
    }
}
