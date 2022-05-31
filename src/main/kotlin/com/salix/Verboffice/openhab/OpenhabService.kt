package com.salix.Verboffice.openhab

import com.salix.Verboffice.openhab.domain.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OpenhabService(
    @Autowired val openhabRestService: OpenhabRestService
) {
    fun getItems(): Flux<Item>? {
        return openhabRestService.getItems()
    }

    fun getItem(name: String): Mono<Item> {
        return openhabRestService.getItem(name)
    }
}