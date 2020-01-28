package com.jopp.functionalkotlin.exchangedata.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
import org.springframework.web.client.RequestCallback
import org.springframework.web.client.ResponseExtractor
import org.springframework.web.client.RestOperations
import java.net.URI

class SpyRestTemplate: RestOperations {

    lateinit var getUrlcalledwith: String
    lateinit var stubbedGet: String

    val objectMapper = ObjectMapper().registerModule(KotlinModule())

    override fun <T : Any?> postForObject(p0: String, p1: Any?, p2: Class<T>, vararg p3: Any?): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> postForObject(p0: String, p1: Any?, p2: Class<T>, p3: MutableMap<String, *>): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> postForObject(p0: URI, p1: Any?, p2: Class<T>): T? {
        TODO("not implemented")
    }

    override fun put(p0: String, p1: Any?, vararg p2: Any?) {
        TODO("not implemented")
    }

    override fun put(p0: String, p1: Any?, p2: MutableMap<String, *>) {
        TODO("not implemented")
    }

    override fun put(p0: URI, p1: Any?) {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: String, p1: HttpMethod, p2: HttpEntity<*>?, p3: Class<T>, vararg p4: Any?): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: String, p1: HttpMethod, p2: HttpEntity<*>?, p3: Class<T>, p4: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: URI, p1: HttpMethod, p2: HttpEntity<*>?, p3: Class<T>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: String, p1: HttpMethod, p2: HttpEntity<*>?, p3: ParameterizedTypeReference<T>, vararg p4: Any?): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: String, p1: HttpMethod, p2: HttpEntity<*>?, p3: ParameterizedTypeReference<T>, p4: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: URI, p1: HttpMethod, p2: HttpEntity<*>?, p3: ParameterizedTypeReference<T>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: RequestEntity<*>, p1: Class<T>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> exchange(p0: RequestEntity<*>, p1: ParameterizedTypeReference<T>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> getForEntity(p0: String, p1: Class<T>, vararg p2: Any?): ResponseEntity<T> {
        getUrlcalledwith = p0

        return ResponseEntity.ok().body(
                objectMapper.readValue(stubbedGet, p1)
        )
    }

    override fun <T : Any?> getForEntity(p0: String, p1: Class<T>, p2: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> getForEntity(p0: URI, p1: Class<T>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun headForHeaders(p0: String, vararg p1: Any?): HttpHeaders {
        TODO("not implemented")
    }

    override fun headForHeaders(p0: String, p1: MutableMap<String, *>): HttpHeaders {
        TODO("not implemented")
    }

    override fun headForHeaders(p0: URI): HttpHeaders {
        TODO("not implemented")
    }

    override fun <T : Any?> getForObject(p0: String, p1: Class<T>, vararg p2: Any?): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> getForObject(p0: String, p1: Class<T>, p2: MutableMap<String, *>): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> getForObject(p0: URI, p1: Class<T>): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> execute(p0: String, p1: HttpMethod, p2: RequestCallback?, p3: ResponseExtractor<T>?, vararg p4: Any?): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> execute(p0: String, p1: HttpMethod, p2: RequestCallback?, p3: ResponseExtractor<T>?, p4: MutableMap<String, *>): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> execute(p0: URI, p1: HttpMethod, p2: RequestCallback?, p3: ResponseExtractor<T>?): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> postForEntity(p0: String, p1: Any?, p2: Class<T>, vararg p3: Any?): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> postForEntity(p0: String, p1: Any?, p2: Class<T>, p3: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun <T : Any?> postForEntity(p0: URI, p1: Any?, p2: Class<T>): ResponseEntity<T> {
        TODO("not implemented")
    }

    override fun optionsForAllow(p0: String, vararg p1: Any?): MutableSet<HttpMethod> {
        TODO("not implemented")
    }

    override fun optionsForAllow(p0: String, p1: MutableMap<String, *>): MutableSet<HttpMethod> {
        TODO("not implemented")
    }

    override fun optionsForAllow(p0: URI): MutableSet<HttpMethod> {
        TODO("not implemented")
    }

    override fun <T : Any?> patchForObject(p0: String, p1: Any?, p2: Class<T>, vararg p3: Any?): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> patchForObject(p0: String, p1: Any?, p2: Class<T>, p3: MutableMap<String, *>): T? {
        TODO("not implemented")
    }

    override fun <T : Any?> patchForObject(p0: URI, p1: Any?, p2: Class<T>): T? {
        TODO("not implemented")
    }

    override fun postForLocation(p0: String, p1: Any?, vararg p2: Any?): URI? {
        TODO("not implemented")
    }

    override fun postForLocation(p0: String, p1: Any?, p2: MutableMap<String, *>): URI? {
        TODO("not implemented")
    }

    override fun postForLocation(p0: URI, p1: Any?): URI? {
        TODO("not implemented")
    }

    override fun delete(p0: String, vararg p1: Any?) {
        TODO("not implemented")
    }

    override fun delete(p0: String, p1: MutableMap<String, *>) {
        TODO("not implemented")
    }

    override fun delete(p0: URI) {
        TODO("not implemented")
    }

}
