package com.chaoscorp.chaosServer.data.mapper;

import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.api.dto.ChaosListSimpleDto
import com.chaoscorp.chaosServer.api.dto.UserDto
import com.chaoscorp.chaosServer.data.model.ChaosList
import com.chaoscorp.chaosServer.data.model.User
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface IChaosMapper {

    @Mapping(source = "list.user.id", target = "idUser")
    fun convertToDto(list : ChaosList) : ChaosListDto

    @Mapping(source = "list.user.id", target = "idUser")
    fun convertToSimpleDto(list : ChaosList) : ChaosListSimpleDto

    @InheritInverseConfiguration(name = "convertToDto")
    fun convertToModel(list : ChaosListDto) : ChaosList

    fun convertToDto(user : User) : UserDto
}
