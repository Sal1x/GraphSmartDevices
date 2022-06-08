package com.salix.Verboffice.controller

import com.salix.Verboffice.controller.DTO.DeviceDTO
import com.salix.Verboffice.controller.DTO.LocationDTO
import com.salix.Verboffice.neo4j.NeoService
import com.salix.Verboffice.neo4j.entities.Device
import com.salix.Verboffice.neo4j.entities.State
import com.salix.Verboffice.openhab.OpenhabService
import com.salix.Verboffice.openhab.domain.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class MainController {
    @Autowired
    lateinit var neoService: NeoService

    @Autowired
    lateinit var openhabService: OpenhabService

    @GetMapping("/hello")
    fun root(): String = "Hello world"

    @GetMapping("/devices")
    fun getItems(): Flux<DeviceDTO> = neoService.getDevices().map { DeviceDTO.fromValue(it) }

    @GetMapping("/devices/{itemName}")
    fun getItemInfo(@PathVariable("itemName") itemName: String): Mono<DeviceDTO> {
        return neoService.getDevice(itemName).map { DeviceDTO.fromValue(it) }
    }

    @GetMapping("/locations")
    fun getLocation(): Flux<LocationDTO> = neoService.getLocations().map { LocationDTO.fromLocation(it) }

    @GetMapping("/locations/{locationName}")
    fun getLocation(@PathVariable("locationName") locationName: String): Mono<LocationDTO> =
        neoService.getLocation(locationName).map { LocationDTO.fromLocation(it) }

    @GetMapping("/import")
    fun importData(): Flux<DeviceDTO> {
        return openhabService.getItems()
            .map(this::fromValue)
            .map(neoService::saveDevice)
            .concatMap{ it.map { device -> DeviceDTO.fromValue(device) }}
    }

    private fun fromValue(item: Item): Device {
        return Device(name = item.name, type_ = item.type)
    }
}