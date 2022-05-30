package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode
import org.springframework.data.neo4j.core.support.DateLong
import java.util.*

@RelationshipProperties
data class StateRel(
    @Id @GeneratedValue
    val id: Long?,
    @TargetNode
    val state: State,
    @DateLong
    val since: Date
)
