package com.frs.console.system.test.core

import com.frs.console.system.test.core.extenstion.TimingExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.context.ApplicationContext
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation
import org.springframework.test.web.reactive.server.WebTestClient

@AutoConfigureWebTestClient
@ExtendWith(RestDocumentationExtension::class, TimingExtension::class)
abstract class AbstractWebClientTestForDocument {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    protected lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun setUp(restDocumentation: RestDocumentationContextProvider) {
        this.webTestClient = WebTestClient
            .bindToApplicationContext(applicationContext)
            .configureClient()
            .baseUrl("https://api.example.com")
            .filter(WebTestClientRestDocumentation.documentationConfiguration(restDocumentation))
            .build()
    }
}