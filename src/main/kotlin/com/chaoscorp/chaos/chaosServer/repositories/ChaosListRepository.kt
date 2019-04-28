package com.chaoscorp.chaos.chaosServer.repositories

import io.ebean.BeanRepository
import io.ebean.EbeanServer
import main.kotlin.com.chaoscorp.chaos.chaosServer.data.ChaosList
import org.springframework.stereotype.Component

@Component
class  ChaosListRepository(server : EbeanServer)
    : BeanRepository<Long, ChaosList>(ChaosList::class.java, server) {

    fun create(list : ChaosList) : ChaosList {

        server.save(list)
        return list;
    }


}