package feature

import com.chaoscorp.chaosServer.App
import com.chaoscorp.chaosServer.config.AppConfig
import com.intuit.karate.junit4.Karate
import org.junit.BeforeClass


import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ConfigurableApplicationContext

lateinit var server : ConfigurableApplicationContext

@RunWith(Karate::class)
@SpringBootTest(classes = arrayOf(AppConfig::class))
//@CucumberOptions(features = arrayOf("classpath:ChaosListController"))
class ChaosListControllerTest {

    companion object {

        //private lateinit var server : ConfigurableApplicationContext

        @JvmStatic
        @BeforeClass
        fun setup() {

            if (::server.isInitialized.not()) {
                server = App.runApp(emptyArray())
            }


        }
    }



}