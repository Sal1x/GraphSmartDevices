package com.salix.GraphSmartDevices.controller.DTO

import com.fasterxml.jackson.annotation.JsonProperty
import com.salix.GraphSmartDevices.neo4j.entities.Device
import com.salix.GraphSmartDevices.neo4j.entities.DeviceGroup
import com.salix.GraphSmartDevices.neo4j.entities.Location
import kotlin.streams.toList

data class LocationDTO(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("label")
    val label: String?,
    @JsonProperty("members")
    val members: List<Any?>?
) {
    companion object FromLocation {
        fun fromLocation(location: Location): LocationDTO {
            val mems = location.member?.stream()?.map {
                when (it) {
                    is DeviceGroup -> DeviceGroupDTO.fromDeviceGroupWithoutMembers(it)
                    is Device -> DeviceDTO.fromValue(it)
                    else -> null
                }
            }?.toList()
            return LocationDTO(
                name = location.name,
                label = location.label,
                members = mems
            )
        }
    }
}
