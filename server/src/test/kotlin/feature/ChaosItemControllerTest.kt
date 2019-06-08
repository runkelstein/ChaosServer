package feature

import com.chaoscorp.chaosServer.config.AppConfig
import com.intuit.karate.junit4.Karate
import cucumber.api.CucumberOptions
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest

@RunWith(Karate::class)
@SpringBootTest(classes = arrayOf(AppConfig::class))
@CucumberOptions(features = arrayOf("classpath:feature/ChaosItemController.feature"))
class ChaosItemControllerTest {

    companion object {

        @JvmStatic
        @BeforeClass
        fun setup() {

            ServerRunner.start();

        }
    }

}