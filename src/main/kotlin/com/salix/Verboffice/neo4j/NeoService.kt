package com.salix.Verboffice.neo4j

import com.salix.Verboffice.neo4j.entities.Device
import com.salix.Verboffice.neo4j.entities.DeviceGroup
import com.salix.Verboffice.neo4j.entities.Location
import com.salix.Verboffice.neo4j.repos.DeviceGroupRepo
import com.salix.Verboffice.neo4j.repos.DeviceRepo
import com.salix.Verboffice.neo4j.repos.LocationRepo
import com.salix.Verboffice.neo4j.repos.StateRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class NeoService {
    @Autowired
    lateinit var deviceRepo: DeviceRepo

    @Autowired
    lateinit var locationRepo: LocationRepo

    @Autowired
    lateinit var deviceGroupRepo: DeviceGroupRepo

    @Autowired
    lateinit var stateRepo: StateRepo

    fun getDevices(): Flux<Device> = deviceRepo.findAll()

    fun getDevice(name: String): Mono<Device> = deviceRepo.findDeviceByName(name)

    fun getLocations(): Flux<Location> = locationRepo.findAll()

    fun getLocation(name: String): Mono<Location> = locationRepo.findByName(name = name)

    fun getDeviceGroup(): Flux<DeviceGroup> = deviceGroupRepo.findAll()

    fun saveDevice(device: Device): Mono<Device>{
        return deviceRepo.save(device)
    }
}