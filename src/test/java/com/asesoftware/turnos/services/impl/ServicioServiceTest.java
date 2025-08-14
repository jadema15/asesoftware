package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.mappers.ServicioMapper;
import com.asesoftware.turnos.models.ServicioEntity;
import com.asesoftware.turnos.models.dto.ServicioDto;
import com.asesoftware.turnos.repository.ServicioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ServicioServiceTest {

    private ServicioRepository servicioRepository;
    private ServicioMapper servicioMapper;
    private ServicioService servicioService;
    @BeforeEach
    void setUp() {
        servicioRepository = Mockito.mock(ServicioRepository.class);
        servicioMapper = Mockito.mock(ServicioMapper.class);
        servicioService = new ServicioService(servicioRepository, servicioMapper);
    }

    @Test
    void testGetServicioAll_withResults() {
        // Arrange
        List<ServicioEntity> listMock = List.of(
                new ServicioEntity(1L, 1L, "Servicio 1", LocalTime.now(), LocalTime.now(), 2 ),
                new ServicioEntity(2L, 1L, "Servicio 2", LocalTime.now(), LocalTime.now(), 2 )
        );

        List<ServicioDto> dtoListMock = List.of(
                new ServicioDto(1L, 1L, "Servicio 1", LocalTime.now(), LocalTime.now(), 2 ),
                new ServicioDto(2L, 1L, "Servicio 2", LocalTime.now(), LocalTime.now(), 2 )
        );

        when(servicioRepository.findAll()).thenReturn(listMock);
        when(servicioMapper.listToDto(listMock)).thenReturn(dtoListMock);

        // Act
        List<ServicioDto> result = servicioService.getServicioAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Servicio 1", result.get(0).getNomServicio());
    }

    @Test
    void testGetServicioAll_withOutResults() {
        // Arrange
        List<ServicioEntity> listMock = List.of();

        List<ServicioDto> dtoListMock = List.of();

        when(servicioRepository.findAll()).thenReturn(listMock);
        when(servicioMapper.listToDto(listMock)).thenReturn(dtoListMock);

        // Act
        List<ServicioDto> result = servicioService.getServicioAll();

        // Assert
        assertEquals(0, result.size());
    }

}