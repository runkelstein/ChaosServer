package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.api.commands.ChangeChaosListCommand
import com.chaoscorp.chaosServer.api.commands.CreateChaosListCommand
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.data.mapper.ChaosMapper
import com.chaoscorp.chaosServer.data.model.ChaosList
import com.chaoscorp.chaosServer.repositories.ChaosListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteList(@RequestParam id : Long) {

        listRepo.deleteById(id);

    }

    @PutMapping("/change")
    fun changeList(@RequestParam id : Long,
                   @RequestBody @Valid command : ChangeChaosListCommand) : ResponseEntity<ChaosListDto> {

        val list = listRepo.findById(id) ?:
            return ResponseEntity.status(404).build();

        list.name = command.name;
        listRepo.save(list);

        return ResponseEntity.ok(chaosMapper.convertToDto(list));
    }

}