package com.asesoftware.turnos.services;

import com.asesoftware.turnos.models.dto.ComercioDto;

import java.util.List;

public interface IComercioService {
    List<ComercioDto> getComercioAll();
}
