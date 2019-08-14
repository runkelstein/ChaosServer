package com.chaoscorp.chaosServer.controller

import com.chaoscorp.chaosServer.aop.Authorize
import com.chaoscorp.chaosServer.api.commands.ChangeChaosListCommand
import com.chaoscorp.chaosServer.api.commands.CreateChaosListCommand
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.api.dto.ChaosListSimpleDto
import com.chaoscorp.chaosServer.data.mapper.IChaosMapper
import com.chaoscorp.chaosServer.data.model.ChaosList
import com.chaoscorp.chaosServer.exception.EntityNotFoundException
import com.chaoscorp.chaosServer.repositories.ChaosListRepository
import com.chaoscorp.chaosServer.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

// todo: validate signed in user: write @Authorize annotation
@RestController
@RequestMapping("/chaosList")
@Component
class ChaosListController(
    val listRepo : ChaosListRepository,
    val userRepo : UserRepository,
    val chaosMapper : IChaosMapper) {

    @Authorize
    @GetMapping("/listing/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    fun list(@PathVariable idUser : Long) : List<ChaosListSimpleDto> {

        val all = listRepo.findAllForUser(idUser)
        return all.map { chaosMapper.convertToSimpleDto(it) }

    }

    @Authorize
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createList(@RequestBody @Valid command : CreateChaosListCommand) : ChaosListDto {

        val user = userRepo.findById(command.idUser) ?:
            throw EntityNotFoundException("User ${command.idUser} does not exist")

        val newList = listRepo.create(ChaosList(
            name = command.name,
            doc = command.doc,
            user = user));
        
        return chaosMapper.convertToDto(newList)
    }

    @Authorize
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getList(@PathVariable id : Long) : ChaosListDto
    {
        val list = listRepo.findById(id) ?:
            throw EntityNotFoundException("List $id does not exist")

        return chaosMapper.convertToDto(list);
    }

    @Authorize
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteList(@PathVariable id : Long) {

        listRepo.deleteById(id);

    }

    @Authorize
    @PutMapping("/change/{id}")
    fun changeList(@PathVariable id : Long,
                   @RequestBody @Valid command : ChangeChaosListCommand) : ChaosListDto {

        val list = listRepo.findById(id) ?:
            throw EntityNotFoundException("List $id does not exist")

        list.name = command.name;
        list.doc = command.doc;
        listRepo.save(list);

        return chaosMapper.convertToDto(list);
    }

}