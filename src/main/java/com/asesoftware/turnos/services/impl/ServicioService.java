package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.mappers.ServicioMapper;
import com.asesoftware.turnos.models.ServicioEntity;
import com.asesoftware.turnos.models.dto.ServicioDto;
import com.asesoftware.turnos.repository.ServicioRepository;
import com.asesoftware.turnos.services.IServicioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicioService implements IServicioService {

    private ServicioRepository servicioRepository;
    private final ServicioMapper servicioMapper;
    @Override
    public List<ServicioDto> getServicioAll() {
        List<ServicioEntity> listaServicios = servicioRepository.findAll();
        if(!listaServicios.isEmpty()){
            return servicioMapper.listToDto(listaServicios);
        }
        return new ArrayList<>();
    }
}