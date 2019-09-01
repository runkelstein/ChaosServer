package com.chaoscorp.chaosServer.repositories

import com.chaoscorp.chaosServer.data.model.User
import com.chaoscorp.chaosServer.data.model.query.QUser
import io.ebean.BeanRepository
import io.ebean.EbeanServer
import org.springframework.stereotype.Component

@Component
class  UserRepository(server : EbeanServer)
    : BeanRepository<Long, User>(User::class.java, server) {

    fun findByGoogleUserId(googleUserId : String) : User? =
        QUser().googleUserId.eq(googleUserId).findOne()

    fun create(user : User) : User {

        save(user)
        return user;
    }

}