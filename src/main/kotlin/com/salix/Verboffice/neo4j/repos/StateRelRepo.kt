package com.salix.Verboffice.neo4j.repos

import com.salix.Verboffice.neo4j.entities.StateRel
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository

interface StateRelRepo : ReactiveNeo4jRepository<StateRel, Long> {
}