package com.salix.Verboffice.openhab

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class OpenhabConfig {

    @Bean
    fun getWebClientBuilder(): WebClient.Builder = WebClient.builder()
}