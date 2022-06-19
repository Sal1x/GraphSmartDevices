package com.salix.GraphSmartDevices.neo4j.repos

import com.salix.GraphSmartDevices.neo4j.entities.Location
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import reactor.core.publisher.Mono

interface LocationRepo : ReactiveNeo4jRepository<Location, Long> {
    fun findByName(name: String): Mono<Location>
}