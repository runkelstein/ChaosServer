package com.chaoscorp.chaosServer.data.model

import com.chaoscorp.chaosServer.api.model.Document
import io.ebean.annotation.DbJson
import io.ebean.annotation.DbJsonB
import javax.persistence.*

@Entity @Table(name="ChaosList")
data class ChaosList(

    @Id
    var id : Long = 0,

    @Column(columnDefinition = "TEXT")
    var doc : String = "",

    @Column
    var name : String = ""

)