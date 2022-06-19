package com.salix.GraphSmartDevices.controller.DTO

import com.fasterxml.jackson.annotation.JsonProperty
import com.salix.GraphSmartDevices.neo4j.entities.DeviceGroup

data class DeviceGroupDTO(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("label")
    val label: String?,
) {
    companion object {
        fun fromDeviceGroupWithoutMembers(deviceGroup: DeviceGroup): DeviceGroupDTO {
            return DeviceGroupDTO(name = deviceGroup.name, label = deviceGroup.label)
        }
    }

}
