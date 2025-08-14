package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.mappers.ComercioMapper;
import com.asesoftware.turnos.models.ComercioEntity;
import com.asesoftware.turnos.models.dto.ComercioDto;
import com.asesoftware.turnos.repository.ComercioRepository;
import com.asesoftware.turnos.services.IComercioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class ComercioService implements IComercioService {

    private ComercioRepository comercioRepository;
    private final ComercioMapper comercioMapper;
    @Override
    public List<ComercioDto> getComercioAll() {
        List<ComercioEntity> listaComercio = comercioRepository.findAll();
        if(!listaComercio.isEmpty()){
            return comercioMapper.listToDto(listaComercio);
        }
        log.info("No se han econtrado elementos");
        return new ArrayList<>();
    }
}
