package com.salix.GraphSmartDevices.openhab.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Item(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("state")
    val state: String,
    @JsonProperty("label")
    val label: String?,
    @JsonProperty("editable")
    val editable: Boolean?,
    @JsonProperty("link")
    val link: String?,
    @JsonProperty("tags")
    val tags: List<String>?,
    @JsonProperty("groupNames")
    val groupNames: List<String>?
)
