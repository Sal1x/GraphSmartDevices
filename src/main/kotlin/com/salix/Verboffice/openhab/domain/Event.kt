package com.salix.Verboffice.openhab.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Event(
    @JsonProperty("data")
    val eventData: EventData
) {
    companion object {
        fun fromValue(string: String): Event {
            val data: String = string
                .replace(regex = Regex("\\\\\\\\"), "")
            return Event(eventData = EventData.fromValue(data))
        }
    }
}
