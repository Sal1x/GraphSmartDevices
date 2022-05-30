package com.salix.Verboffice.controller.DTO

import com.salix.Verboffice.neo4j.entities.Device
import com.salix.Verboffice.neo4j.entities.DeviceGroup
import com.salix.Verboffice.neo4j.entities.Location
import kotlin.streams.toList

data class LocationDTO(
    val name: String,
    val label: String?,
    val member: List<Any?>
) {
    companion object FromLocation {
        fun fromLocation(location: Location): LocationDTO {
            println(location.member)
            val members: List<Any?> = location.member.stream().map {
                when (it) {
                    is DeviceGroup -> DeviceGroupDTO.fromDeviceGroupWithoutMembers(it)
                    is Device -> DeviceDTO.fromDevice(it)
                    else -> null
                }
            }.toList()
            return LocationDTO(
                name = location.name,
                label = location.label,
                member = members
            )
        }
    }
}
