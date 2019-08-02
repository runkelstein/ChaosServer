package com.chaoscorp.chaosServer.data.model

import com.chaoscorp.chaosServer.api.model.Document
import io.ebean.annotation.DbJson
import io.ebean.annotation.DbJsonType
import javax.persistence.*

@Entity @Table(name="ChaosList")
data class ChaosList(

    @Id
    var id : Long = 0,
    
    @ManyToOne
    @JoinColumn(name="IdUser")
    var user : User = User(),

    @DbJson(storage = DbJsonType.VARCHAR)
    var doc : Document = Document(),

    @Column
    var name : String = ""

)