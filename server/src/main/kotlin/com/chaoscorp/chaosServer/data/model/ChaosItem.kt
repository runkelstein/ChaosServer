package com.chaoscorp.chaosServer.data.model

import javax.persistence.*

@Entity
@Table(name="ChaosItem")
data class ChaosItem(

        @Id
        var id : Long = 0,

        @Column
        var done: Boolean = false,

        @Column
        var content : String = "",

        @ManyToOne
        @JoinColumn(name = "chaosList", referencedColumnName="id")
        var chaosList : ChaosList? = null,

        @ManyToOne
        @JoinColumn(name = "chaosItem", referencedColumnName="id")
        val parent : ChaosItem? = null,

        @OneToMany(mappedBy = "parent", cascade = arrayOf(CascadeType.ALL))
        var items : MutableList<ChaosItem> = ArrayList()

)