package main.kotlin.com.chaoscorp.chaos.chaosServer.data

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
        var chaosList : ChaosList

)