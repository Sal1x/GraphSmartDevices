package com.salix.Verboffice.controller

import com.salix.Verboffice.openhab.domain.Item
import com.salix.Verboffice.openhab.OpenhabService
import org.springframework.beans.factory.annotation.Autowired
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
}