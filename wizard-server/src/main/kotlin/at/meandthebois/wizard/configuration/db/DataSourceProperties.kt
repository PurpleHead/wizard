package at.meandthebois.wizard.configuration.db

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.datasource")
data class DataSourceProperties(var url: String, var driverClassName: String)