package com.salix.Verboffice.neo4j.repos

import com.salix.Verboffice.neo4j.entities.State
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

interface StateRepo: ReactiveNeo4jRepository<State, Long> {
}