package com.chaoscorp.chaosServer.client

import com.chaoscorp.chaosServer.api.commands.ChangeChaosListCommand
import com.chaoscorp.chaosServer.api.commands.CreateChaosListCommand
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.api.dto.ChaosListSimpleDto
import feign.Headers
import feign.Param
import feign.RequestLine

// todo: make workable with idToken
@Headers("Content-Type: application/json")
interface ChaosClient {

    @RequestLine("POST /auth/googleSignin")
    @Headers("idGoogleToken: {idToken}")
    fun googleSignin(@Param("idToken") idToken:String) : List<ChaosListSimpleDto>

    @RequestLine("GET /chaosList/listing/{idUser}")
    fun getListing(@Param("idUser") idUser:Long) : List<ChaosListSimpleDto>

    @RequestLine("GET /chaosList/get/{id}")
    fun getList(@Param("id") id:Long) : ChaosListDto

    @RequestLine("POST /chaosList/create")
    fun createList(command : CreateChaosListCommand) : ChaosListDto

    @RequestLine("PUT /chaosList/change/{id}")
    fun changeList(@Param("id") id:Long, command : ChangeChaosListCommand) : ChaosListDto

    @RequestLine("DELETE /chaosList/delete/{id}")
    fun deleteList(@Param("id") id:Long) : ChaosListDto
}