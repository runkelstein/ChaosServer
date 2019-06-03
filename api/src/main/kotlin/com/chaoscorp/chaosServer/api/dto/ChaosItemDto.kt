package com.chaoscorp.chaosServer.api.dto

data class ChaosItemDto(
    var id : Long = 0,
    var done : Boolean = false,
    var content : String = "",
    var items : List<ChaosItemDto> = ArrayList()
)