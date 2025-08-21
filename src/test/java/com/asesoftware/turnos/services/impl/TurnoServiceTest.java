package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.exceptions.GenerarTurnoException;
import com.asesoftware.turnos.mappers.TurnoMapper;
import com.asesoftware.turnos.models.ServicioEntity;
import com.asesoftware.turnos.models.TurnoEntity;
import com.asesoftware.turnos.models.dto.RequestTurnoDto;
import com.asesoftware.turnos.models.dto.ServicioDto;
import com.asesoftware.turnos.models.dto.TurnoDto;
import com.asesoftware.turnos.repository.TurnoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TurnoServiceTest {

    private TurnoRepository turnoRepository;
    private TurnoMapper turnoMapper;
    private TurnoService turnoService;

    private String FECHA_INICIO = "2025-08-14 08:00:00";
    private String FECHA_FIN = "2025-08-14 18:00:00";
    @BeforeEach
    void setUp() {
        turnoRepository = Mockito.mock(TurnoRepository.class);
        turnoMapper = Mockito.mock(TurnoMapper.class);
        turnoService = new TurnoService(turnoRepository, turnoMapper);
    }

    @Test
    void testGetTurnoAll_withResults() {
        // Arrange
        ServicioEntity servicioEntity = ServicioEntity.builder().idServicio(1L).build();
        List<TurnoEntity> listMock = List.of(
                new TurnoEntity(1L,servicioEntity, new Date(),LocalTime.now(), LocalTime.now(), "A" ),
                new TurnoEntity(2L, servicioEntity,new Date(),LocalTime.now(), LocalTime.now(), "A")
        );

        ServicioDto servicioDto = ServicioDto.builder().idServicio(1L).build();
        List<TurnoDto> dtoListMock = List.of(
                new TurnoDto(1L, new Date(),LocalTime.now(), LocalTime.now(), "A", servicioDto ),
                new TurnoDto(2L,new Date(),LocalTime.now(), LocalTime.now(), "A", servicioDto )
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

    @Test
    void testGetGenerarTurno_Success() {
        // Arrange
        Timestamp fechaInicio = Timestamp.valueOf(FECHA_INICIO);
        Timestamp fechaFin = Timestamp.valueOf(FECHA_FIN);
        Long idServicio = 1L;

        RequestTurnoDto requestTurnoDto = new RequestTurnoDto();
        requestTurnoDto.setFechaInicio(fechaInicio);
        requestTurnoDto.setFechaFin(fechaFin);
        requestTurnoDto.setIdServicio(idServicio);

        // Act
        Boolean result = turnoService.getGenerarTurno(requestTurnoDto);

        // Assert
        assertTrue(result);
        verify(turnoRepository, times(1)).getGenerarTurno(fechaInicio, fechaFin, idServicio);
    }

    @Test
    void testGetGenerarTurno_ThrowsException() {
        // Arrange
        Timestamp fechaInicio = Timestamp.valueOf(FECHA_INICIO);
        Timestamp fechaFin = Timestamp.valueOf(FECHA_FIN);
        Long idServicio = 1L;

        RequestTurnoDto dto = new RequestTurnoDto();
        dto.setFechaInicio(fechaInicio);
        dto.setFechaFin(fechaFin);
        dto.setIdServicio(idServicio);

        doThrow(new RuntimeException("Se ha presentado un error en el PR")).when(turnoRepository).getGenerarTurno(fechaInicio, fechaFin, idServicio);

        // Act & Assert
        GenerarTurnoException exception = assertThrows(GenerarTurnoException.class, () -> {
            turnoService.getGenerarTurno(dto);
        });

        assertEquals("Error al generar turno", exception.getMessage());
        verify(turnoRepository, times(1)).getGenerarTurno(fechaInicio, fechaFin, idServicio);
    }

    @Test
    void testDeleteTurno_Success(){
        // Arrange
        doNothing().when(turnoRepository).eliminarallturnos();
        // Act
        Boolean result = turnoService.eliminarAllTurnos();

        // Assert
        assertTrue(result);
        verify(turnoRepository, times(1)).eliminarallturnos();
    }

    @Test
    void testDeleteTurno_ThrowsException() {
        // Arrange
        doThrow(new RuntimeException("Se ha presentado un error en el PR")).when(turnoRepository).eliminarallturnos();

        // Act & Assert
        GenerarTurnoException exception = assertThrows(GenerarTurnoException.class, () -> {
            turnoService.eliminarAllTurnos();
        });
        
        // Assert
        assertEquals("Error al eliminar todos los turnos", exception.getMessage());
        verify(turnoRepository, times(1)).eliminarallturnos();

    }
}