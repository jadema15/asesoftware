package com.asesoftware.turnos.controllers;

import com.asesoftware.turnos.models.dto.ServicioDto;
import com.asesoftware.turnos.services.IServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/servicio")
@RequiredArgsConstructor
@Tag(name = "Servicio", description = "Operaciones relacionadas con servicios prestados")
public class ServicioController {

    private final IServicioService servicio;

    @Operation(summary = "Obtener todos los servicios", description = "Retorna lista de todos los servicios disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de servicios obtenida correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron servicios"),
            @ApiResponse(responseCode = "500", description = "Error en la ejecución de la lógica de negocio.")
    })
    @GetMapping
    public ResponseEntity<List<ServicioDto>> getServicioAll(){
        return ResponseEntity.of(Optional.ofNullable(servicio.getServicioAll()));
    }

    @Operation(summary = "Obtener todos los servicios por comercio", description = "Retorna lista de todos los servicios disponibles por comercio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de servicios obtenida correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron servicios"),
            @ApiResponse(responseCode = "500", description = "Error en la ejecución de la lógica de negocio.")
    })
    @GetMapping("/comercio/{id}")
    public ResponseEntity<List<ServicioDto>> getServicioByComercio(@PathVariable Long id){
        return ResponseEntity.of(Optional.ofNullable(servicio.getServicioByComercio(id)));
    }
}