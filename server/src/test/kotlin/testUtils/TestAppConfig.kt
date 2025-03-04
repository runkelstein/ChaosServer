package com.chaoscorp.chaosServer.testUtils

import com.google.api.client.util.Clock
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.*

@TestConfiguration
@ComponentScan("com.chaoscorp.chaosServer.testUtils")
class TestAppConfig {

    val fixedUnitTimestamp = 1566116271000L // 04.08.2019 12:42:20

    @Bean()
    fun googleClock() : Clock {
        return Clock {
            fixedUnitTimestamp
        };
    }



}