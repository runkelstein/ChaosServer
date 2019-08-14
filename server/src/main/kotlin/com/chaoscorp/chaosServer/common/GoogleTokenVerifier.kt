package com.chaoscorp.chaosServer.common

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.util.Clock
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class GoogleTokenVerifier(
    val jsonFactory : JsonFactory,
    val transport : HttpTransport,
    val clock : Clock,
    @Value("\${chaosServer.googleClientId}") val clientId : String) {

    fun verify(token : String) : Boolean {
        return verifyAndGetPayload(token) != null
    }

    fun verifyAndGetPayload(token : String) : GoogleIdToken.Payload? {

        val verifier = GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setClock(clock)
            .setAudience(listOf(clientId))
            .build()

        return verifier.verify(token)?.payload
    }

}