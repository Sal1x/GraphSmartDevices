package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property

@Node("State")
data class State(
    @Id
    @GeneratedValue
    val id: Long?,

    @Property("value")
    val value: String,

    @Property("type_")
    val type_: String
)