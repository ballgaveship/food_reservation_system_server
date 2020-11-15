package com.frs.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class FrsDiscoveryApplication

fun main(args: Array<String>) {
    runApplication<FrsDiscoveryApplication>(*args)
}