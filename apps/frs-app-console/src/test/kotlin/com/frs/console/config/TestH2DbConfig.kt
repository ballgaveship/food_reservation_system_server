package com.frs.console.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@EnableR2dbcRepositories("com.frs.console.repository")
@Configuration
class TestH2DbConfig : AbstractR2dbcConfiguration() {
    @Bean
    fun initializer(@Qualifier("h2ConnectionFactory") connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory)
        initializer.setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
        return initializer
    }

    @Bean("h2ConnectionFactory")
    override fun connectionFactory(): H2ConnectionFactory {
        return H2ConnectionFactory(
                H2ConnectionConfiguration.builder()
                        .url("mem:db;DB_CLOSE_DELAY=-1;")
                        .username("sa")
                        .build()
        )
    }
}