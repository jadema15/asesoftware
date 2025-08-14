package com.asesoftware.turnos.mappers;

import com.asesoftware.turnos.models.ComercioEntity;
import com.asesoftware.turnos.models.dto.ComercioDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ComercioMapper {
    ComercioMapper INSTANCE = Mappers.getMapper(ComercioMapper.class);
    ComercioDto toDto(ComercioEntity personaEntity);
    ComercioEntity toEntity(ComercioDto comercioDto);
    List<ComercioDto> listToDto(List<ComercioEntity> list);

}
