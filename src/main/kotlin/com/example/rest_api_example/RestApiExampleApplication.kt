package com.example.rest_api_example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class RestApiExampleApplication

fun main(args: Array<String>) {
	runApplication<RestApiExampleApplication>(*args)
}

@RestController
class HelloWorldController {

	@RequestMapping("/hello-world", method = [RequestMethod.GET])
	fun helloWorld() : String {
		return "Hello World"
	}
}