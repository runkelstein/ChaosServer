package com.chaoscorp.chaosServer.client

import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder

object ClientBuilder {

    fun createChaosListClient(serverHost : String) : ChaosListClient {
        return Feign.builder()
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            .target(ChaosListClient::class.java, serverHost)
    }

}