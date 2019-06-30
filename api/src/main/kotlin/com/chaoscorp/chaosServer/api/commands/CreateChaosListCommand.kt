package com.chaoscorp.chaosServer.api.commands

import com.chaoscorp.chaosServer.api.model.Document
import javax.validation.constraints.NotBlank

class CreateChaosListCommand(
        @NotBlank
        val name : String,
        val doc : Document = Document()) {
}