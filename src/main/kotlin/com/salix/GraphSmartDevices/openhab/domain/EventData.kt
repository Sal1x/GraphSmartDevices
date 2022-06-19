package com.salix.GraphSmartDevices.openhab.domain

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

data class EventData(
    @JsonProperty("topic")
    val topic: String,
    @JsonProperty("payload")
    val payload: String,
    @JsonProperty("type")
    val type: String
) {
    companion object {
        fun fromValue(string: String): EventData {
            val objectMapper = ObjectMapper()
            return objectMapper.readValue(string, EventData::class.java)
        }
    }
}
