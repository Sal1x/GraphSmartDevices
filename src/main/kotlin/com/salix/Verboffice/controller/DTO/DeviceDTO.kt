package com.salix.Verboffice.controller.DTO

import com.fasterxml.jackson.annotation.JsonProperty
import com.salix.Verboffice.neo4j.entities.Device

data class DeviceDTO(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("type_")
    val type_: String,
    @JsonProperty("state")
    val state: StateDTO
) {
    companion object {
        fun fromValue(device: Device): DeviceDTO {
            return DeviceDTO(
                name = device.name,
                type_ = device.type_,
                state = StateDTO.fromState(device.states)
            )
        }
    }
}
