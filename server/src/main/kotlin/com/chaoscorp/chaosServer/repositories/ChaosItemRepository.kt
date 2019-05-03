package com.chaoscorp.chaosServer.repositories

import com.chaoscorp.chaosServer.data.model.ChaosItem
import io.ebean.BeanRepository
import io.ebean.EbeanServer
import org.springframework.stereotype.Component

@Component
class  ChaosItemRepository(server : EbeanServer)
    : BeanRepository<Long, ChaosItem>(ChaosItem::class.java, server) {
}
