package com.chaoscorp.chaos.chaosServer.data.mapper;

import com.chaoscorp.chaos.chaosServer.api.dto.ChaosListDto
import main.kotlin.com.chaoscorp.chaos.chaosServer.data.ChaosList;
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ChaosMapper {

    fun convertToDto(list : ChaosList) : ChaosListDto

}
