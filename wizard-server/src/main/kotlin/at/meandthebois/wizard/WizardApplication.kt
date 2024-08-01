package at.meandthebois.wizard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class WizardApplication

fun main(args: Array<String>) {
    runApplication<WizardApplication>(*args)
}
