package at.meandthebois.wizard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@ConfigurationPropertiesScan
@EnableJpaRepositories
class WizardApplication

fun main(args: Array<String>) {
    runApplication<WizardApplication>(*args)
}
