package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.api.commands.AddChaosItemCommand
import com.chaoscorp.chaosServer.api.dto.ChaosItemDto
import com.chaoscorp.chaosServer.data.mapper.IChaosMapper
import com.chaoscorp.chaosServer.repositories.ChaosItemRepository
import com.chaoscorp.chaosServer.repositories.ChaosListRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/chaosItem")
@Component
class ChaosItemController(
    val listRepo : ChaosListRepository,
    val itemRepo : ChaosItemRepository,
    val chaosMapper : IChaosMapper
) {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody @Valid command : AddChaosItemCommand) : ResponseEntity<Any> {

        if (command.idItem == null && command.idList == null) {
            return status(HttpStatus.BAD_REQUEST).build()
        }

        var newItem = chaosMapper.convertToModel(command.item);

        if (command.idItem != null) {

            val id = command.idItem ?: 0;
            newItem = itemRepo.addItem(id, newItem) ?:
                    return status(HttpStatus.NOT_FOUND).body("List item $id not found");

        } else if (command.idList != null) {

            val id = command.idList ?: 0;
            newItem = listRepo.addItem(id, newItem) ?:
                    return status(HttpStatus.NOT_FOUND).body("List $id not found");
        }

        return ok(chaosMapper.convertToDto(newItem))
    }

}