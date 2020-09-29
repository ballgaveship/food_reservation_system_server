package com.frs.console

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FrsAdminApplication

fun main(args: Array<String>) {
    runApplication<FrsAdminApplication>(*args)
}