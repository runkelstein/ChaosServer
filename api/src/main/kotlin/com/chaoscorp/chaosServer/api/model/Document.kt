package com.chaoscorp.chaosServer.api.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Document(
        var title: String = "",
        var items: MutableList<Item> = mutableListOf())