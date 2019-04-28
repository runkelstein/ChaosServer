package main.kotlin.com.chaoscorp.chaos.chaosServer.data

import javax.persistence.*
import kotlin.collections.List

@Entity @Table(name="ChaosList")
class ChaosList(

    @Id
    var id : Long = 0,

    @OneToMany(mappedBy = "chaosList")
    var items : List<ChaosItem> = ArrayList(),

    @Column
    var name : String = ""

)