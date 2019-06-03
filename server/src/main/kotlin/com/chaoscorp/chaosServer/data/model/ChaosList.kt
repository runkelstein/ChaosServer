package com.chaoscorp.chaosServer.data.model

import javax.persistence.*
import kotlin.collections.List

@Entity @Table(name="ChaosList")
data class ChaosList(

    @Id
    var id : Long = 0,

    @OneToMany(mappedBy = "chaosList", cascade = arrayOf(CascadeType.ALL))
    var items : MutableList<ChaosItem> = ArrayList(),

    @Column
    var name : String = ""

)