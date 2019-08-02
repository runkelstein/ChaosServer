package com.chaoscorp.chaosServer.repositories

import com.chaoscorp.chaosServer.data.model.ChaosList
import com.chaoscorp.chaosServer.data.model.query.QChaosList
import io.ebean.BeanRepository
import io.ebean.EbeanServer
import org.springframework.stereotype.Component

@Component
class  ChaosListRepository(server : EbeanServer)
    : BeanRepository<Long, ChaosList>(ChaosList::class.java, server) {

    fun findAllForUser(idUser : Long) : List<ChaosList> {
        return QChaosList()
            .user.id.eq(idUser)
            .findList()
    }

    fun create(list : ChaosList) : ChaosList {

        save(list)
        return list
    }

}