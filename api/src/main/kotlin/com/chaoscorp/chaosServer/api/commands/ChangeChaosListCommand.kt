package com.chaoscorp.chaosServer.api.commands

import javax.validation.constraints.NotBlank

class ChangeChaosListCommand(
    @NotBlank
    val name : String) {



}