package com.frs.console.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@EnableR2dbcRepositories("com.frs.console.repository")
@Configuration
class AppConfig {
    @Bean
    fun r2dbcRepositoryFactory(databaseClient: DatabaseClient, dataAccessStrategy: ReactiveDataAccessStrategy): R2dbcRepositoryFactory {
        return R2dbcRepositoryFactory(databaseClient, dataAccessStrategy)
    }
}