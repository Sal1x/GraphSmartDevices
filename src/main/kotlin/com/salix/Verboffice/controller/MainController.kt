package com.salix.Verboffice.controller

import com.salix.Verboffice.controller.DTO.DeviceDTO
import com.salix.Verboffice.controller.DTO.LocationDTO
import com.salix.Verboffice.neo4j.NeoService
import com.salix.Verboffice.neo4j.entities.Device
import com.salix.Verboffice.neo4j.entities.Location
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class MainController {
    @Autowired
    lateinit var neoService: NeoService

    @GetMapping("/hello")
    fun root(): String = "Hello world"

    @GetMapping("/items")
    fun getItems(): Flux<DeviceDTO> = neoService.getDevices().map { DeviceDTO.fromDevice(it) }

    @GetMapping("/items/{itemName}")
    fun getItemInfo(@PathVariable("itemName") itemName: String): Mono<DeviceDTO> =
        neoService.getDeviceInfo(itemName).map { DeviceDTO.fromDevice(it) }

    @GetMapping("/locations")
    fun getLocation(): Flux<LocationDTO> = neoService.getLocation().map { LocationDTO.fromLocation(it) }
//    fun getLocation(): Flux<Location> = neoService.getLocation()

//    @GetMapping("/locations/{itemName}")
//    @PutMapping("/lights")
}