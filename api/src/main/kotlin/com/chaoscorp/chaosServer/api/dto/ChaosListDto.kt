package com.chaoscorp.chaosServer.api.dto

import com.chaoscorp.chaosServer.api.model.Document

data class ChaosListDto(
    var id : Long = 0, var name : String = "", var doc : Document = Document()
)