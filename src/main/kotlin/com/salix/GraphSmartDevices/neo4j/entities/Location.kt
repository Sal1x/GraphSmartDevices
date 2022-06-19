package com.salix.GraphSmartDevices.neo4j.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Location(
    @Property("name") override val name: String,

    @Property("label") val label: String? = null,

    @Relationship(value = "member", direction = Relationship.Direction.OUTGOING)
    override val member: MutableList<OpenhabItem>? = null,

    @Relationship(value = "member", direction = Relationship.Direction.INCOMING)
    override val group: MutableList<OpenhabItem>? = null,

    @Id @GeneratedValue override val id: Long? = null
) : OpenhabGroup
