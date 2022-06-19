package com.salix.GraphSmartDevices.neo4j.repos

import com.salix.GraphSmartDevices.neo4j.entities.Device
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import reactor.core.publisher.Mono

interface DeviceRepo: ReactiveNeo4jRepository<Device, Long> {
    fun findDeviceByName(name: String): Mono<Device>
}