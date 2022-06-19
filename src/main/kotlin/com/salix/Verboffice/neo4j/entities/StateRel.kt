package com.salix.Verboffice.neo4j.entities

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.neo4j.core.schema.*
import org.springframework.data.neo4j.core.support.DateLong
import java.util.Date

@RelationshipProperties
data class StateRel(
    @TargetNode var state: State,
    @DateLong @CreatedDate val since: Date? = null,
    @RelationshipId val id: Long? = null
){
    fun haveState(state: State){
        this.state = state
    }
}
