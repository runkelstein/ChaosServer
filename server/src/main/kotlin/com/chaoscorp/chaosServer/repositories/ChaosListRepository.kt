package com.chaoscorp.chaosServer.repositories

import com.chaoscorp.chaosServer.data.model.ChaosList
import io.ebean.BeanRepository
import io.ebean.EbeanServer
import org.springframework.stereotype.Component

@Component
class  ChaosListRepository(server : EbeanServer)
    : BeanRepository<Long, ChaosList>(ChaosList::class.java, server) {

    fun create(list : ChaosList) : ChaosList {

        server.save(list)
        return list;
    }


}