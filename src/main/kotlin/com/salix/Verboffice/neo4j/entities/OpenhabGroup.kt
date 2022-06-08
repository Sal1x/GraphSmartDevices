package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.Node

@Node("OpenhabGroup")
sealed interface OpenhabGroup: OpenhabItem {
    val member: List<OpenhabItem>?
}