package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship

@Node("DeviceGroup")
data class DeviceGroup(
    @Id
    override val id: Long? = null,

    @Property
    override val name: String,

    @Property
    val label: String? = null,

    @Relationship(value = "member", direction = Relationship.Direction.OUTGOING)
    override val member: List<OpenhabItem>? = null,

    @Relationship(value = "member", direction = Relationship.Direction.INCOMING)
    override val group: List<OpenhabItem>? = null
) : OpenhabGroup
