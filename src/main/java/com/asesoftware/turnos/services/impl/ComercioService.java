package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.mappers.ComercioMapper;
import com.asesoftware.turnos.models.ComercioEntity;
import com.asesoftware.turnos.models.dto.ComercioDto;
import com.asesoftware.turnos.repository.ComercioRepository;
import com.asesoftware.turnos.services.IComercioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComercioService implements IComercioService {

    private ComercioRepository comercioRepository;
    @Override
    public List<ComercioDto> getComercioAll() {
        List<ComercioEntity> listaComercio = comercioRepository.findAll();
        if(!listaComercio.isEmpty()){
            return ComercioMapper.INSTANCE.listToDto(listaComercio);
        }
        return new ArrayList<>();
    }
}
