package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Location(
    @Id
    @GeneratedValue
    override val id: Long?,

    @Property
    override val name: String,

    @Property("label")
    val label: String?,

    @Relationship(value = "member", direction = Relationship.Direction.OUTGOING)
    override val member: Set<OpenhabItem>,

    @Relationship(value = "member", direction = Relationship.Direction.INCOMING)
    override val group: Set<OpenhabItem>
) : OpenhabGroup
