package com.jopp.functionalkotlin.functional

import io.restassured.specification.RequestSpecification
import org.apache.commons.io.IOUtils
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.junit4.SpringRunner
import java.nio.charset.Charset

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class FunctionalTest {

    @LocalServerPort
    protected val port: Int = 0

    protected fun RequestSpecification.When(): RequestSpecification {
        return this.`when`()
    }

    protected fun readFileContents(testFixture: String): String {
        val resource = ClassPathResource(testFixture).inputStream
        return IOUtils.toString(resource, Charset.defaultCharset())
    }
}