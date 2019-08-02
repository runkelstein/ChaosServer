package com.chaoscorp.chaosServer.data.model

import com.chaoscorp.chaosServer.api.model.Document
import io.ebean.annotation.DbJson
import io.ebean.annotation.DbJsonType
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="User")
data class User(

    @Id
    var id : Long = 0,

    @Column
    var googleUserId : String = "",

    @Column
    var name : String = "",

    @Column
    var email : String = "",

    @Column
    var lastLogin : ZonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"))
)