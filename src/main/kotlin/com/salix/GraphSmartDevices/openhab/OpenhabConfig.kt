package com.salix.GraphSmartDevices.openhab

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class OpenhabConfig(

) {
    @Value("\${openhab.baseUrl}")
    private val baseUrl: String = ""

    @Bean
    fun getWebClientBuilder(): WebClient.Builder = WebClient.builder().baseUrl(baseUrl)
}