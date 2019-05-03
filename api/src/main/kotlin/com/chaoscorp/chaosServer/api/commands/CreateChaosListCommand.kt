package com.chaoscorp.chaosServer.api.commands

import javax.validation.constraints.NotBlank

class CreateChaosListCommand(
        @NotBlank
        val name : String) {
}