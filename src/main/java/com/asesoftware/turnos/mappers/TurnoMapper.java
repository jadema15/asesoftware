package com.asesoftware.turnos.mappers;

import com.asesoftware.turnos.models.TurnoEntity;
import com.asesoftware.turnos.models.dto.TurnoDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TurnoMapper {
    TurnoDto toDto(TurnoEntity turnoEntity);
    TurnoEntity toEntity(TurnoDto turnoDto);
    List<TurnoDto> listToDto(List<TurnoEntity> list);
}