package com.chaoscorp.chaosServer.repositories

import com.chaoscorp.chaosServer.data.model.ChaosList
import com.chaoscorp.chaosServer.data.model.User
import io.ebean.BeanRepository
import io.ebean.EbeanServer
import org.springframework.stereotype.Component

@Component
class  UserRepository(server : EbeanServer)
    : BeanRepository<Long, User>(User::class.java, server) {

    fun create(user : User) : User {

        save(user)
        return user;
    }

}