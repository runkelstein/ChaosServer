package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.api.commands.CreateChaosListCommand
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.data.mapper.ChaosMapper
import com.chaoscorp.chaosServer.data.model.ChaosList
import com.chaoscorp.chaosServer.repositories.ChaosListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/chaosList")
@Component
class ChaosListController(val listRepo : ChaosListRepository) {

    @Autowired
    lateinit var chaosMapper : ChaosMapper;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createList(@RequestBody @Valid command : CreateChaosListCommand) : ChaosListDto {

        val newList = listRepo.create(ChaosList(name = command.name));
        
        return chaosMapper.convertToDto(newList)
    }

}