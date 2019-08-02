package com.chaoscorp.chaosServer.api.dto

import com.chaoscorp.chaosServer.api.model.Document

data class ChaosListSimpleDto(
    var id : Long = 0,
    var name : String = "",
    var idUser : Long = 0
)