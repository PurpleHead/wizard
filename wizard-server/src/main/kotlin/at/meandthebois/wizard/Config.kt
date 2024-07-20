package at.meandthebois.wizard

import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource

@Configuration
@EnableJpaRepositories(basePackages = ["at.meandthebois.wizard"])
class DbConfig {
    @Autowired private var env: Environment? = null

    @Bean
    fun dataSource(): DataSource {
        var dataSource: DriverManagerDataSource = DriverManagerDataSource()

        dataSource.setDriverClassName(env?.getProperty("driverClassName")!!)
        dataSource.setUrl(env?.getProperty("url"))

        return dataSource
    }
}
