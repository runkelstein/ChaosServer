package com.chaoscorp.chaos.chaosServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication()
class App {



	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<App>(*args)
		}
	}

}
