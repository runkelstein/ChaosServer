package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.api.dto.UserDto
import com.chaoscorp.chaosServer.common.GoogleTokenVerifier
import com.chaoscorp.chaosServer.data.mapper.IChaosMapper
import com.chaoscorp.chaosServer.data.model.User
import com.chaoscorp.chaosServer.exception.ForbiddenException
import com.chaoscorp.chaosServer.repositories.UserRepository
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/signIn")
@Component
class SignInController(
    val userRepo : UserRepository,
    val tokenVerifier : GoogleTokenVerifier,
    val mapper : IChaosMapper) {

    @PostMapping("/google")
    @ResponseStatus(HttpStatus.OK)
    fun googleSignin(@RequestHeader(value="idGoogleToken")  googleToken : String) : UserDto {

        val payload = tokenVerifier.verifyAndGetPayload(googleToken) ?:
            throw ForbiddenException("Access denied. No valid google token!")

        val user = userRepo.findByGoogleUserId(payload.subject) ?: createUser(payload)

        return mapper.convertToDto(user)
    }

    fun createUser(payload : GoogleIdToken.Payload) =
        userRepo.create(User(
            googleUserId = payload.subject,
            email = payload.email,
            name = payload.getOrDefault("name","UNKNOWN NAME") as String))

}