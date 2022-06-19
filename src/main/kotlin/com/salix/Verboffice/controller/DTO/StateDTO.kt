package com.salix.Verboffice.controller.DTO

import com.fasterxml.jackson.annotation.JsonProperty
import com.salix.Verboffice.neo4j.entities.State
import com.salix.Verboffice.neo4j.entities.StateRel

data class StateDTO(
    @JsonProperty("value")
    val value: String,
    @JsonProperty("type_")
    val type_: String
) {
    companion object FromState {
        fun fromState(stateList: Set<StateRel>?): StateDTO {
            return if (stateList != null) {
                StateDTO(value = stateList.last().state.value, type_ = stateList.last().state.type_)
            } else {
                StateDTO(value = "NULL", type_ = "INIT")
            }

        }
    }
}
