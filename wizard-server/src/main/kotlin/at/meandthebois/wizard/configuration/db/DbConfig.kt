package at.meandthebois.wizard.configuration.db

import javax.sql.DataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource

@Configuration
@EnableJpaRepositories(basePackages = ["at.meandthebois.wizard"])
class DbConfig {
    @Bean
    fun dataSource(dataSourceProperties: DataSourceProperties): DataSource {
        var dataSource: DriverManagerDataSource = DriverManagerDataSource()

        dataSource.setDriverClassName(dataSourceProperties.driverClassName)
        dataSource.url = dataSourceProperties.url

        return dataSource
    }
}
