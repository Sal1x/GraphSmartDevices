package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.Node

@Node("OpenhabItem")
sealed interface OpenhabItem {
    val id: Long?
    val name: String
    val group: List<OpenhabItem>?
}