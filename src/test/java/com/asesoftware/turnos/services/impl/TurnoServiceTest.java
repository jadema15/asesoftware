package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.mappers.TurnoMapper;
import com.asesoftware.turnos.models.ServicioEntity;
import com.asesoftware.turnos.models.TurnoEntity;
import com.asesoftware.turnos.models.dto.ServicioDto;
import com.asesoftware.turnos.models.dto.TurnoDto;
import com.asesoftware.turnos.repository.TurnoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class TurnoServiceTest {

    private TurnoRepository turnoRepository;
    private TurnoMapper turnoMapper;
    private TurnoService turnoService;
    @BeforeEach
    void setUp() {
        turnoRepository = Mockito.mock(TurnoRepository.class);
        turnoMapper = Mockito.mock(TurnoMapper.class);
        turnoService = new TurnoService(turnoRepository, turnoMapper);
    }

    @Test
    void testGetTurnoAll_withResults() {
        // Arrange
        List<TurnoEntity> listMock = List.of(
                new TurnoEntity(1L, 1L,new Date(),LocalTime.now(), LocalTime.now(), "A"),
                new TurnoEntity(2L, 1L,new Date(),LocalTime.now(), LocalTime.now(), "A")
        );

        List<TurnoDto> dtoListMock = List.of(
                new TurnoDto(1L, 1L,new Date(),LocalTime.now(), LocalTime.now(), "A" ),
                new TurnoDto(2L, 1L,new Date(),LocalTime.now(), LocalTime.now(), "A" )
        );

        when(turnoRepository.findAll()).thenReturn(listMock);
        when(turnoMapper.listToDto(listMock)).thenReturn(dtoListMock);

        // Act
        List<TurnoDto> result = turnoService.getTurnosAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("A", result.get(0).getEstado());
    }

    @Test
    void testGetTurnoAll_withOutResults() {
        // Arrange
        List<TurnoEntity> listMock = List.of();

        List<TurnoDto> dtoListMock = List.of();

        when(turnoRepository.findAll()).thenReturn(listMock);
        when(turnoMapper.listToDto(listMock)).thenReturn(dtoListMock);

        // Act
        List<TurnoDto> result = turnoService.getTurnosAll();

        // Assert
        assertEquals(0, result.size());
    }
}