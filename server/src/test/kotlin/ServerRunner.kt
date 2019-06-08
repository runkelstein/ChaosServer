import com.chaoscorp.chaosServer.App
import org.springframework.context.ConfigurableApplicationContext

lateinit var server : ConfigurableApplicationContext

object ServerRunner {

    fun start() {

        if (::server.isInitialized.not()) {
            server = App.runApp(emptyArray())
        }

    }
}