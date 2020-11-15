package com.frs.console

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FrsConsoleApplication

fun main(args: Array<String>) {
    runApplication<FrsConsoleApplication>(*args)
}