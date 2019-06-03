package com.chaoscorp.chaosServer.repositories

import com.chaoscorp.chaosServer.data.model.ChaosItem
import com.chaoscorp.chaosServer.data.model.ChaosList
import io.ebean.BeanRepository
import io.ebean.EbeanServer
import org.springframework.stereotype.Component
import java.util.*

@Component
class  ChaosListRepository(server : EbeanServer)
    : BeanRepository<Long, ChaosList>(ChaosList::class.java, server) {

    fun create(list : ChaosList) : ChaosList {

        save(list)
        return list;
    }

    fun addItem(id : Long,  item : ChaosItem) : ChaosItem? {

        val list = findById(id) ?: return null;
        list.items.add(item);
        update(list)

        return item;
    }

}