package com.asesoftware.turnos.controllers;

import com.asesoftware.turnos.models.dto.ComercioDto;
import com.asesoftware.turnos.services.IComercioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comercio")
@RequiredArgsConstructor
@Tag(name = "Comercio", description = "Operaciones relacionadas con comercios")
public class ComercioController {

    private final IComercioService comercio;

    @Operation(summary = "Obtener todos los comercios", description = "Retorna una lista de todos los comercios disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de comercios obtenida correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron comercios"),
            @ApiResponse(responseCode = "500", description = "Error en la ejecución de la lógica de negocio.")
    })
    @GetMapping
    public ResponseEntity<List<ComercioDto>> getComercioAll(){
        return ResponseEntity.of(Optional.ofNullable(comercio.getComercioAll()));
    }
}
