package com.salix.Verboffice.neo4j.entities


sealed interface OpenhabItem {
    val name: String
    val group: Set<OpenhabItem>
}