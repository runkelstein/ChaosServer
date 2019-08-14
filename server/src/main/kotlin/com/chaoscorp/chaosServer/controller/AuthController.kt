package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.common.GoogleTokenVerifier
import com.chaoscorp.chaosServer.data.model.User
import com.chaoscorp.chaosServer.exception.ForbiddenException
import com.chaoscorp.chaosServer.repositories.UserRepository

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
@Component
class AuthController(
    val userRepo : UserRepository,
    val tokenVerifier : GoogleTokenVerifier) {

    @PostMapping("/googleSignin")
    @ResponseStatus(HttpStatus.OK)
    fun googleSignin(@RequestHeader(value="idGoogleToken")  googleToken : String) {

        val payload = tokenVerifier.verifyAndGetPayload(googleToken) ?:
            throw ForbiddenException("Access denied. No valid google token!")

        val user = User(
            googleUserId = payload.subject,
            email = payload.email,
            name = payload.getOrDefault("name","UNKNOWN NAME") as String)

        userRepo.create(user);
    }

}