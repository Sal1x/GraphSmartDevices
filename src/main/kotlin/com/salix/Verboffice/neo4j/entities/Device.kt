package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship

@Node("Device")
data class Device(
    @Id
    @GeneratedValue
    val id: Long?,

    @Property("name")
    override val name: String,

    @Property("type_")
    val type_: String,

    @Relationship(type = "StateRel", direction = Relationship.Direction.OUTGOING)
    val state: Set<State>,

    @Relationship(type="member", direction = Relationship.Direction.INCOMING)
    override val group: Set<OpenhabItem>

) : OpenhabItem