package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.mappers.TurnoMapper;
import com.asesoftware.turnos.models.TurnoEntity;
import com.asesoftware.turnos.models.dto.RequestTurnoDto;
import com.asesoftware.turnos.models.dto.TurnoDto;
import com.asesoftware.turnos.repository.TurnoRepository;
import com.asesoftware.turnos.services.ITurnoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoService implements ITurnoService {

    private TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;

    @Override
    public List<TurnoDto> getTurnosAll() {
        List<TurnoEntity> listaTurnos = turnoRepository.findAll();
        if(!listaTurnos.isEmpty()){
            return turnoMapper.listToDto(listaTurnos);
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean getGenerarTurno(RequestTurnoDto requestTurnoDto) {

        Timestamp fechaInicio = requestTurnoDto.getFechaInicio();
        Timestamp fechaFin = requestTurnoDto.getFechaFin();
        Long idServicio = requestTurnoDto.getIdServicio();
        turnoRepository.getGenerarTurno(fechaInicio,fechaFin , idServicio);
        return true;
    }
}