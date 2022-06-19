package com.salix.Verboffice.neo4j.repos

import com.salix.Verboffice.neo4j.entities.Device
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

interface DeviceRepo: ReactiveNeo4jRepository<Device, Long> {
    fun findDeviceByName(name: String): Mono<Device>
}