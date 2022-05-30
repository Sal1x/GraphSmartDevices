package com.salix.Verboffice.neo4j

import com.salix.Verboffice.neo4j.entities.Device
import com.salix.Verboffice.neo4j.entities.DeviceGroup
import com.salix.Verboffice.neo4j.entities.Location
import com.salix.Verboffice.neo4j.repos.DeviceGroupRepo
import com.salix.Verboffice.neo4j.repos.DeviceRepo
import com.salix.Verboffice.neo4j.repos.LocationRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class NeoService {
    @Autowired
    lateinit var deviceRepo: DeviceRepo

    @Autowired
    lateinit var locationRepo: LocationRepo

    @Autowired
    lateinit var deviceGroupRepo: DeviceGroupRepo

    fun getDevices(): Flux<Device> = deviceRepo.findAll()

    fun getLocation(): Flux<Location> = locationRepo.findAll()

    fun getDeviceGroup(): Flux<DeviceGroup> = deviceGroupRepo.findAll()
}