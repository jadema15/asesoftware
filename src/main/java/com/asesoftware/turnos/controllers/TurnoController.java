package com.asesoftware.turnos.controllers;

import com.asesoftware.turnos.models.dto.RequestTurnoDto;
import com.asesoftware.turnos.models.dto.TurnoDto;
import com.asesoftware.turnos.services.ITurnoService;
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
@RequestMapping("/api/turno")
@RequiredArgsConstructor
@Tag(name = "Turno", description = "Operaciones relacionadas con los turnos")
public class TurnoController {

    private final ITurnoService turnoService;

    @Operation(summary = "Obtener todos los turnos", description = "Retorna lista de todos los turnos creados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de turnos obtenida correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron turnos"),
            @ApiResponse(responseCode = "500", description = "Error en la ejecución de la lógica de negocio.")
    })
    @GetMapping
    public ResponseEntity<List<TurnoDto>> getTurnoAll() {
        return ResponseEntity.of(Optional.ofNullable(turnoService.getTurnosAll()));
    }

    @Operation(summary = "Registra un nuevo turno", description = "Registra un nuevo turno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turno registrado con éxito"),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado recurso"),
            @ApiResponse(responseCode = "500", description = "Error en la ejecución de la lógica de negocio.")
    })
    @PostMapping()
    public ResponseEntity<Boolean> postGenerarTurno(@RequestBody RequestTurnoDto requestTurnoDto){
        return ResponseEntity.of(Optional.ofNullable(turnoService.getGenerarTurno(requestTurnoDto)));
    }
}