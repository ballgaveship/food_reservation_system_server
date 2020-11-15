package com.frs.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
class FrsConfigServerApplication

fun main(args: Array<String>) {
    runApplication<FrsConfigServerApplication>(*args)
}