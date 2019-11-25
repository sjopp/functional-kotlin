package com.jopp.functionalkotlin.functional

import io.restassured.specification.RequestSpecification
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class FunctionalTest {

    protected fun RequestSpecification.When(): RequestSpecification {
        return this.`when`()
    }
}