package com.chaoscorp.chaosServer.feature

import com.chaoscorp.chaosServer.App
import com.chaoscorp.chaosServer.config.AppConfig
import com.chaoscorp.chaosServer.testUtils.TestAppConfig
import com.intuit.karate.KarateOptions
import com.intuit.karate.junit4.Karate
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestContextManager


@RunWith(Karate::class)
@KarateOptions(features = arrayOf("classpath:features/ChaosListController.feature"))
class ChaosListControllerTest {

    @ActiveProfiles("unittesting")
    @SpringBootTest(classes=arrayOf(AppConfig::class, TestAppConfig::class, App::class), webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
    companion object {

        @JvmStatic
        @BeforeClass
        fun setup() {
            val testContext = TestContextManager(this::class.java)
            testContext.prepareTestInstance(this)
        }
    }

}