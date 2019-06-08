package com.chaoscorp.chaosServer.client

import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder

object ClientBuilder {

    fun createChaosListClient(serverHost : String) : ChaosClient {
        return Feign.builder()
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            .target(ChaosClient::class.java, serverHost)
    }

}