package com.chaoscorp.chaos.chaosServer.repositories

import io.ebean.BeanRepository
import io.ebean.EbeanServer
import main.kotlin.com.chaoscorp.chaos.chaosServer.data.ChaosItem
import org.springframework.stereotype.Component

@Component
class  ChaosItemRepository(server : EbeanServer)
    : BeanRepository<Long, ChaosItem>(ChaosItem::class.java, server) {
}
