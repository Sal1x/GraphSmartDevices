package com.salix.GraphSmartDevices.neo4j.repos

import com.salix.GraphSmartDevices.neo4j.entities.State
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository

interface StateRepo: ReactiveNeo4jRepository<State, Long> {
}