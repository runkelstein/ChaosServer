package com.chaoscorp.chaosServer.api.commands

import com.chaoscorp.chaosServer.api.model.Document
import javax.validation.constraints.NotBlank

class ChangeChaosListCommand(
    @NotBlank val name : String,
    @NotBlank val idUser : Long,
    val doc : Document = Document()
)