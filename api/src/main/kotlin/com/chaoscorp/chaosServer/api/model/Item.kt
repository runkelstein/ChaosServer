package com.chaoscorp.chaosServer.api.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Item(
        var type: DocumentType = DocumentType.text,
        var level: Int = 0,
        var content: String = "",
        var bold: String = "",
        var italic: String = "",
        var items: MutableList<Item> = mutableListOf())