package com.salix.Verboffice.controller.DTO

import com.fasterxml.jackson.annotation.JsonProperty
import com.salix.Verboffice.neo4j.entities.State

data class StateDTO(
    @JsonProperty("value")
    val value: String,
    @JsonProperty("type_")
    val type_: String
) {
    companion object FromState {
        fun fromState(state: State?): StateDTO {
            if (state != null) {
                return StateDTO(value = state.value, type_ = state.type_)
            } else {
                return StateDTO(value = "NULL", type_ = "INIT")
            }

        }
    }
}
