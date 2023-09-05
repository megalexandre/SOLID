package solid.s

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SApplication

fun main(args: Array<String>) {
	runApplication<SApplication>(*args)
}
