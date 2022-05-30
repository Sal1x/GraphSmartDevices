package com.salix.Verboffice.neo4j.entities

sealed interface OpenhabGroup: OpenhabItem {
    val member: Set<OpenhabItem>
}