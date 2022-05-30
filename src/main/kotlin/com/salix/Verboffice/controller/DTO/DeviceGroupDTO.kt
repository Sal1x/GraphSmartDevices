package com.salix.Verboffice.controller.DTO

import com.salix.Verboffice.neo4j.entities.DeviceGroup

data class DeviceGroupDTO(
    val name: String,
    val label: String?,
) {
    companion object {
        fun fromDeviceGroupWithoutMembers(deviceGroup: DeviceGroup): DeviceGroupDTO {
            return DeviceGroupDTO(name = deviceGroup.name, label = deviceGroup.label)
        }
    }

}
