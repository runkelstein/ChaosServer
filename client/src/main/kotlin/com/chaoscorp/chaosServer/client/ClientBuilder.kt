package com.chaoscorp.chaosServer.client
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import okhttp3.OkHttpClient
import java.net.Proxy
import feign.okhttp.OkHttpClient as FeignOkHttpClient

object ClientBuilder {

    fun createChaosListClient(serverHost : String, googleSignInToken : String) : ChaosClient {
        return Feign.builder()
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            .client(FeignOkHttpClient())
            .requestInterceptor {
                it.header("idGoogleToken", googleSignInToken)
            }
            .target(ChaosClient::class.java, serverHost)
    }

    fun createChaosListClient(serverHost : String, googleSignInToken : String, proxy : Proxy) : ChaosClient {

        val httpClient = FeignOkHttpClient(OkHttpClient.Builder().proxy(proxy).build());

        return Feign.builder()
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            .client(httpClient)
            .requestInterceptor {
                it.header("idGoogleToken", googleSignInToken)
            }
            .target(ChaosClient::class.java, serverHost)
    }

}