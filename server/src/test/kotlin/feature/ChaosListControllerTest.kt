package feature

import com.chaoscorp.chaosServer.App
import com.chaoscorp.chaosServer.config.AppConfig
import com.intuit.karate.junit4.Karate
import cucumber.api.CucumberOptions
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest

@RunWith(Karate::class)
@CucumberOptions(features = arrayOf("classpath:feature/ChaosListController.feature"))
class ChaosListControllerTest {

    companion object {

        @JvmStatic
        @BeforeClass
        fun setup() {

            ServerRunner.start();

        }
    }

}