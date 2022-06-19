package com.salix.Verboffice.neo4j

import com.salix.Verboffice.neo4j.entities.*
import com.salix.Verboffice.neo4j.repos.*
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
    lateinit var stateRelRepo: StateRelRepo

    @Autowired
    lateinit var stateRepo: StateRepo

    fun getDevices(): Flux<Device> = deviceRepo.findAll()

    fun getDevice(name: String): Mono<Device> = deviceRepo.findDeviceByName(name)

    fun getLocations(): Flux<Location> = locationRepo.findAll()

    fun getLocation(name: String): Mono<Location> = locationRepo.findByName(name = name)

    fun getDeviceGroup(): Flux<DeviceGroup> = deviceGroupRepo.findAll()

    fun save(device: Device): Mono<Device> {
        return deviceRepo.save(device)
    }

    fun save(state: State): Mono<State> {
        return stateRepo.save(state)
    }
    fun save(stateRel: StateRel): Mono<StateRel> {
        return stateRelRepo.save(stateRel)
    }

    fun combine(device: Device, state: State): Device {
        device.haveState(state)
        return device
    }

    fun combine(device: Device, stateRel: StateRel): Device {
        device.haveState(stateRel)
        return device
    }


}