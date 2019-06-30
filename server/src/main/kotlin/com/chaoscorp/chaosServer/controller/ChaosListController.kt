package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.api.commands.ChangeChaosListCommand
import com.chaoscorp.chaosServer.api.commands.CreateChaosListCommand
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.data.mapper.DocumentMapper
import com.chaoscorp.chaosServer.data.mapper.IChaosMapper
import com.chaoscorp.chaosServer.data.model.ChaosList
import com.chaoscorp.chaosServer.repositories.ChaosListRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/chaosList")
@Component
class ChaosListController(
    val listRepo : ChaosListRepository,
    val chaosMapper : IChaosMapper) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createList(@RequestBody @Valid command : CreateChaosListCommand) : ChaosListDto {

        val mapper = DocumentMapper()
        val newList = listRepo.create(ChaosList(
            name = command.name,
            doc = mapper.asString(command.doc)));
        
        return chaosMapper.convertToDto(newList)
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getList(@PathVariable id : Long)
            : ResponseEntity<ChaosListDto>
    {
        val list = listRepo.findById(id) ?:
            return ResponseEntity.status(404).build();

        return ResponseEntity.ok(chaosMapper.convertToDto(list));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteList(@PathVariable id : Long) {

        listRepo.deleteById(id);

    }

    @PutMapping("/change/{id}")
    fun changeList(@PathVariable id : Long,
                   @RequestBody @Valid command : ChangeChaosListCommand) : ResponseEntity<ChaosListDto> {

        val list = listRepo.findById(id) ?:
            return ResponseEntity.status(404).build();

        list.name = command.name;
        listRepo.save(list);

        return ResponseEntity.ok(chaosMapper.convertToDto(list));
    }

}