package com.salix.Verboffice.controller

import com.salix.Verboffice.neo4j.NeoService
import com.salix.Verboffice.neo4j.entities.Device
import com.salix.Verboffice.neo4j.entities.Location
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class MainController {
    @Autowired
    lateinit var neoService: NeoService

    @GetMapping("/hello")
    fun root(): String = "Hello world"

    @GetMapping("/items")
    fun getItems(): Flux<Device> = neoService.getDevices()

    //    @GetMapping("/items/{itemName}")
    @GetMapping("/locations")
    fun getLocation(): Flux<Location> = neoService.getLocation()

//    @GetMapping("/locations/{itemName}")
//    @PutMapping("/lights")
}