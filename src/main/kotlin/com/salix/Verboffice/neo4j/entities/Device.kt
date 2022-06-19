package com.salix.Verboffice.neo4j.entities

import org.springframework.data.neo4j.core.schema.*
import java.time.Instant
import java.util.*
import kotlin.collections.HashSet


@Node("Device")
data class Device(
    @Property("name") override val name: String,

    @Property("type_") val type_: String,

    @Relationship(type = "haveState", direction = Relationship.Direction.OUTGOING)
    var states: HashSet<StateRel>? = null,

    @Relationship(type = "member", direction = Relationship.Direction.INCOMING)
    override val group: MutableList<OpenhabItem>? = null,

    @Id @GeneratedValue override val id: Long? = null

) : OpenhabItem {
    fun haveState(state: State) {
        if (states == null) {
            states = HashSet()
        }
        val stateRel = StateRel(state, since = Date.from(Instant.now()))
        states!!.add(stateRel)

        fun haveStateRel(stateRel: StateRel) {
            if (states == null) {
                states = HashSet()
            }
            states!!.add(stateRel)
        }
    }
}