package testUtils

import com.google.api.client.util.Clock
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.*

@TestConfiguration
class TestAppConfig {

    val fixedUnitTimestamp = 1564915340000L // 04.08.2019 12:42:20

    @Bean()
    fun googleClock() : Clock {
        return Clock {
            fixedUnitTimestamp
        };
    }

}