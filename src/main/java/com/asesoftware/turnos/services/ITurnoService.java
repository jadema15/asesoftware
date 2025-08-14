package com.asesoftware.turnos.services;

import com.asesoftware.turnos.models.dto.TurnoDto;

import java.util.List;

public interface ITurnoService {

    List<TurnoDto> getTurnosAll();
}
