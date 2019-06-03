package com.chaoscorp.chaosServer.api.commands

import com.chaoscorp.chaosServer.api.dto.ChaosItemDto

data class AddChaosItemCommand(
    val item : ChaosItemDto = ChaosItemDto(),
    val idList : Long?,
    val idItem : Long?
)