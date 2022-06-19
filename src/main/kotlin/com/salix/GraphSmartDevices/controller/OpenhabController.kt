package com.salix.GraphSmartDevices.controller

import com.salix.GraphSmartDevices.openhab.domain.Item
import com.salix.GraphSmartDevices.openhab.OpenhabService
import com.salix.GraphSmartDevices.openhab.domain.Event
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/oh")
class OpenhabController(
    @Autowired
    val openhabService: OpenhabService
) {
    @GetMapping("/items")
    fun getOpenhabItems(): Flux<Item>? {
        return openhabService.getItems()
    }
    @GetMapping("/items/{name}")
    fun getOpenhabItems(@PathVariable("name") name: String): Mono<Item> {
        return openhabService.getItem(name)
    }
    @GetMapping("/events", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getEvents(): Flux<Event> {
        return openhabService.getEvents()
    }

    @GetMapping("/events/state", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getChangeStateEvents(): Flux<Event> {
        return openhabService.getChangeStateEvents()
    }
}