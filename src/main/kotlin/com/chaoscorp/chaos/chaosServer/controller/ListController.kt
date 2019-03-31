package com.chaoscorp.chaos.chaosServer.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/list")
@Component
class ListController {

    @RequestMapping("/create", method = arrayOf(RequestMethod.GET))
    fun createList() : ResponseEntity<String> {
        return ResponseEntity.of(Optional.of("Hallo Welt"));
    }

}