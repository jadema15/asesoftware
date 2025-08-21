package com.asesoftware.turnos.mappers;

import com.asesoftware.turnos.models.ComercioEntity;
import com.asesoftware.turnos.models.dto.ComercioDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComercioMapper {
    ComercioDto toDto(ComercioEntity comercioEntity);
    ComercioEntity toEntity(ComercioDto comercioDto);
    List<ComercioDto> listToDto(List<ComercioEntity> list);
}
