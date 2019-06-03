package com.chaoscorp.chaosServer.api.dto

data class ChaosListDto(
    var id : Long = 0, var name : String = "",
    var items : List<ChaosItemDto> = ArrayList())