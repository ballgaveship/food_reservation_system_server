package com.frs.console

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
class FrsAdminApplication

fun main(args: Array<String>) {
    runApplication<FrsAdminApplication>(*args)
}