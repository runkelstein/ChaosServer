package com.chaoscorp.chaosServer.config

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.client.util.Clock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("com.chaoscorp.chaos.chaosServer")
class AppConfig {

    @Bean
    fun googleJsonFactory() : JsonFactory {
        return JacksonFactory.getDefaultInstance();
    }

    @Bean
    fun googleHttpTransport() : HttpTransport {
        val transport = GoogleNetHttpTransport.newTrustedTransport()!!;
        return transport;
    }

    @Bean
    fun googleClock() : Clock {
        return Clock.SYSTEM;
    }

}