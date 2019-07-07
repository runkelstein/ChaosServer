package com.chaoscorp.chaosServer.data.mapper;

import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.api.dto.ChaosListSimpleDto
import com.chaoscorp.chaosServer.data.model.ChaosList
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface IChaosMapper {

    fun convertToDto(list : ChaosList) : ChaosListDto
    fun convertToDto(list : List<ChaosList>) : List<ChaosListSimpleDto>

    fun convertToModel(list : ChaosListDto) : ChaosList
}
