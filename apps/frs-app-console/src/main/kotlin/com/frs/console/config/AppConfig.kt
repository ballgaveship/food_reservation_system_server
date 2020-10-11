package com.frs.console.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@EnableR2dbcRepositories
@Configuration
class AppConfig