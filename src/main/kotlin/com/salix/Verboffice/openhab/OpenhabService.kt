package com.salix.Verboffice.openhab

import com.salix.Verboffice.common.ItemChangeState
import com.salix.Verboffice.neo4j.NeoService
import com.salix.Verboffice.openhab.domain.Event
import com.salix.Verboffice.openhab.domain.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OpenhabService(
    @Autowired val openhabRestService: OpenhabRestService,
    @Autowired val neoService: NeoService
) {
    fun getItems(): Flux<Item> {
        return openhabRestService.getItems()
    }

    fun getItem(name: String): Mono<Item> {
        return openhabRestService.getItem(name)
    }

    fun getEvents(): Flux<Event> {
        return openhabRestService.getEvents()
    }

    fun getChangeStateEvents(): Flux<Event> {
        return openhabRestService.getEvents().filter{ it.eventData.type == "ItemStateEvent"}
    }
//    fun getItemWithChangeState(event: Event): Mono<ItemChangeState> {
//        val itemName = Utils.getItemName(event.eventData.topic)
//
//        //todo implement
//    }
}