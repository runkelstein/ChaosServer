package com.chaoscorp.chaosServer.data.mapper;

import com.chaoscorp.chaosServer.api.dto.ChaosItemDto
import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.data.model.ChaosItem
import com.chaoscorp.chaosServer.data.model.ChaosList
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring")
interface IChaosMapper {

    fun convertToDto(list : ChaosList) : ChaosListDto
    fun convertToDto(list : ChaosItem) : ChaosItemDto
    
    fun convertToModel(dto : ChaosItemDto) : ChaosItem
}
