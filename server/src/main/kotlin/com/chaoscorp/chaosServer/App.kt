package com.chaoscorp.chaosServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication()
class App {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApp(args)
		}

		@JvmStatic
		fun runApp(args: Array<String>) : ConfigurableApplicationContext {
			return runApplication<App>(*args)


		}
	}

}
