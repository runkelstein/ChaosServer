package com.chaoscorp.chaosServer.data.mapper;

import com.chaoscorp.chaosServer.api.dto.ChaosListDto
import com.chaoscorp.chaosServer.data.model.ChaosList
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface IChaosMapper {

    fun convertToDto(list : ChaosList) : ChaosListDto

    fun convertToModel(list : ChaosListDto) : ChaosList
}
