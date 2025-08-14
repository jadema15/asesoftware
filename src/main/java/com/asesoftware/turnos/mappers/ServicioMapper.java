package com.asesoftware.turnos.mappers;

import com.asesoftware.turnos.models.ServicioEntity;
import com.asesoftware.turnos.models.dto.ServicioDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ServicioMapper {
   // ServicioMapper INSTANCE = Mappers.getMapper(ServicioMapper.class);
    ServicioDto toDto(ServicioEntity servicioEntity);
    ServicioEntity toEntity(ServicioDto servicioDto);
    List<ServicioDto> listToDto(List<ServicioEntity> list);
}