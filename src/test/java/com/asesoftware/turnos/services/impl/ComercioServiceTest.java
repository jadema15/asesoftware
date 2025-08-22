package com.asesoftware.turnos.services.impl;

import com.asesoftware.turnos.mappers.ComercioMapper;
import com.asesoftware.turnos.models.ComercioEntity;
import com.asesoftware.turnos.models.dto.ComercioDto;
import com.asesoftware.turnos.repository.ComercioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ComercioServiceTest {

    @Mock
    private ComercioRepository comercioRepository;
    @Mock
    private ComercioMapper comercioMapper;
    @InjectMocks
    private ComercioService comercioService;
        @BeforeEach
        void setUp() {
            comercioRepository = Mockito.mock(ComercioRepository.class);
            comercioMapper = Mockito.mock(ComercioMapper.class);
            comercioService = new ComercioService(comercioRepository, comercioMapper);
        }

    @Test
    void testGetComercioAll_withResults() {
        // Arrange
        List<ComercioEntity> listMock = List.of(
                new ComercioEntity(1L, "comercio 1", 1),
                new ComercioEntity(2L, "comercio 2", 1)
        );

        List<ComercioDto> dtoListMock = List.of(
                new ComercioDto(1L, "comercio 1", 1),
                new ComercioDto(2L, "comercio 2", 1)
        );

        when(comercioRepository.findAll()).thenReturn(listMock);
        when(comercioMapper.listToDto(listMock)).thenReturn(dtoListMock);

        // Act
        List<ComercioDto> result = comercioService.getComercioAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("comercio 1", result.get(0).getNomComercio()); 
    }

    @Test
    void testGetComercioAll_withOutResults() {
        // Arrange
        List<ComercioEntity> listMock = List.of();

        List<ComercioDto> dtoListMock = List.of();

        when(comercioRepository.findAll()).thenReturn(listMock);
        when(comercioMapper.listToDto(listMock)).thenReturn(dtoListMock);

        // Act
        List<ComercioDto> result = comercioService.getComercioAll();

        // Assert
        assertEquals(0, result.size());
    }
}