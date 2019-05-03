package com.chaoscorp.chaosServer.client

import com.chaoscorp.chaosServer.api.commands.CreateChaosListCommand
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import feign.Headers
import feign.RequestLine

interface ChaosListClient {

    @RequestLine("POST /chaosList/create")
    @Headers("Content-Type: application/json")
    fun createList(command : CreateChaosListCommand) : ChaosListDto


}