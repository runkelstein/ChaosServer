package com.chaoscorp.chaos.chaosServer.data.mapper;

import com.chaoscorp.chaos.chaosServer.api.dto.ChaosListDto
import main.kotlin.com.chaoscorp.chaos.chaosServer.data.ChaosList;
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers;

@Mapper
interface ChaosMapper {

    companion object  {
        val instance : ChaosMapper = Mappers.getMapper( ChaosMapper::class.java );

    }

    fun convertToDto(list : ChaosList) : ChaosListDto

}
