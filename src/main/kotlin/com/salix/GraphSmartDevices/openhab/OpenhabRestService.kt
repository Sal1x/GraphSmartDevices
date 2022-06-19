package com.salix.GraphSmartDevices.openhab

import com.salix.GraphSmartDevices.openhab.domain.Event
import com.salix.GraphSmartDevices.openhab.domain.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class OpenhabRestService(
    @Autowired
    val webClient: WebClient.Builder
) {

    fun getItems(): Flux<Item> {
        return webClient.build()
            .get()
            .uri("https://demo.openhab.org/rest/items?tags=light")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(Item::class.java)
    }

    fun getItem(name: String): Mono<Item> {
        return webClient.build()
            .get()
            .uri("https://demo.openhab.org/rest/items/{name}", name)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Item::class.java)
    }

    fun getEvents(): Flux<Event> {
        return webClient.build()
            .get()
            .uri("https://demo.openhab.org/rest/events")
            .accept(MediaType.TEXT_EVENT_STREAM)
            .retrieve()
            .bodyToFlux(String::class.java)
            .map(Event::fromValue)
    }

}

