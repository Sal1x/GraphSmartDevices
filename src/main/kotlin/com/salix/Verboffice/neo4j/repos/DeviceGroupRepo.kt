package com.salix.Verboffice.neo4j.repos

import com.salix.Verboffice.neo4j.entities.DeviceGroup
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface DeviceGroupRepo : ReactiveNeo4jRepository<DeviceGroup, Long> {
    fun findByName(name: String): Mono<DeviceGroup>
}