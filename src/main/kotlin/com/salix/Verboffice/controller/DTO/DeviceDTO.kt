package com.salix.Verboffice.controller.DTO

import com.salix.Verboffice.neo4j.entities.Device

data class DeviceDTO(
    val name: String,
    val type_: String,
    val state: StateDTO
) {
    companion object FromDevice {
        fun fromDevice(device: Device): DeviceDTO {
            return DeviceDTO(
                name = device.name,
                type_ = device.type_,
                state = StateDTO.fromState(device.state?.lastOrNull())
            )
        }
    }
}
