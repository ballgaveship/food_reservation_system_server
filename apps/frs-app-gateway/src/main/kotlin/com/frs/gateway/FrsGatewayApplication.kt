package com.frs.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class FrsGatewayApplication

fun main(args: Array<String>) {
    runApplication<FrsGatewayApplication>(*args)
}