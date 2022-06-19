package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship

@Node("State")
data class State(
    @Property("value") var value: String,
    @Property("type_") val type_: String,
    @Relationship(type = "haveState", direction = Relationship.Direction.INCOMING) val device: Device? = null,
    @Id @GeneratedValue val id: Long? = null
)