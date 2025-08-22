package com.asesoftware.turnos.controllers;

import com.asesoftware.turnos.models.dto.ComercioDto;
import com.asesoftware.turnos.services.IComercioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComercioControllerTest {

    @Mock
    private IComercioService comercioService;

    @InjectMocks
    private ComercioController comercioController;

    @BeforeEach
    void setUp() {
        comercioService = Mockito.mock(IComercioService.class);
        comercioController = new ComercioController(comercioService);
    }

    @Test
    void testGetComercioAll_ReturnsList() {
        // Arrange
        ComercioDto comercio1 = new ComercioDto(1L, "Comercio 1", 10);
        ComercioDto comercio2 = new ComercioDto(2L, "Comercio 2", 11);
        List<ComercioDto> expectedList = Arrays.asList(comercio1, comercio2);

        when(comercioService.getComercioAll()).thenReturn(expectedList);

        // Act
        ResponseEntity<List<ComercioDto>> response = comercioController.getComercioAll();

        // Assert
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals("Comercio 1", response.getBody().get(0).getNomComercio());

        verify(comercioService, times(1)).getComercioAll();
    }

    @Test
    void testGetComercioAll_Returns404WhenNull() {
        // Arrange
        when(comercioService.getComercioAll()).thenReturn(null);

        // Act
        ResponseEntity<List<ComercioDto>> response = comercioController.getComercioAll();

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());

        verify(comercioService, times(1)).getComercioAll();
    }

}