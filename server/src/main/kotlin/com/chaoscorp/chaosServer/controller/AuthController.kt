package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.data.model.User
import com.chaoscorp.chaosServer.exception.ForbiddenException
import com.chaoscorp.chaosServer.repositories.UserRepository

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import org.springframework.beans.factory.annotation.Value

@RestController
@RequestMapping("/auth")
@Component
class AuthController(
    val userRepo : UserRepository,
    val jsonFactory : JsonFactory,
    val transport : HttpTransport,
    @Value("\${chaosServer.googleClientId}") val clientId : String) {

    @PostMapping("/googleSignin")
    @ResponseStatus(HttpStatus.OK)
    fun googleSignin(@RequestHeader(value="idGoogleToken")  googleToken : String) {

        val verifier = GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setAudience(listOf(clientId))
            .build()

        val idToken = verifier.verify(googleToken) ?:
            throw ForbiddenException("Access denied. No valid google token!")

        val payload = idToken.payload;
        val user = User(
            googleUserId = payload.subject,
            email = payload.email,
            name = payload.getOrDefault("name","UNKNOWN NAME") as String)

        userRepo.create(user);
    }

}