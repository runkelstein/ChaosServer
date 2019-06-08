package com.chaoscorp.chaosServer.client

import com.chaoscorp.chaosServer.api.commands.AddChaosItemCommand
import com.chaoscorp.chaosServer.api.commands.ChangeChaosListCommand
import com.chaoscorp.chaosServer.api.commands.CreateChaosListCommand
import com.chaoscorp.chaosServer.api.dto.ChaosItemDto
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import feign.Headers
import feign.Param
import feign.RequestLine

interface ChaosClient {

    // list commands

    @RequestLine("GET /chaosList/get/{id}")
    @Headers("Content-Type: application/json")
    fun getList(@Param("id") id:Long) : ChaosListDto

    @RequestLine("POST /chaosList/create")
    @Headers("Content-Type: application/json")
    fun createList(command : CreateChaosListCommand) : ChaosListDto

    @RequestLine("PUT /chaosList/change/{id}")
    @Headers("Content-Type: application/json")
    fun changeList(@Param("id") id:Long, command : ChangeChaosListCommand) : ChaosListDto

    @RequestLine("DELETE /chaosList/delete/{id}")
    @Headers("Content-Type: application/json")
    fun deleteList(@Param("id") id:Long) : ChaosListDto

    // item commands

    @RequestLine("POST /chaosItem/add")
    @Headers("Content-Type: application/json")
    fun addItem(command : AddChaosItemCommand) : ChaosItemDto

    @RequestLine("DELETE /chaosItem/delete/{id}")
    @Headers("Content-Type: application/json")
    fun deleteItem(@Param("id") id:Long) : ChaosListDto
}