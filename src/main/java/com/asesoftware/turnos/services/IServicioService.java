package com.asesoftware.turnos.services;

import com.asesoftware.turnos.models.dto.ServicioDto;

import java.util.List;

public interface IServicioService {
    List<ServicioDto> getServicioAll();
}
