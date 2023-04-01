package de.maxcim.sampleblogbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class SampleBlogBackendApplication

fun main(args: Array<String>) {
	runApplication<SampleBlogBackendApplication>(*args)
}
