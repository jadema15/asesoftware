package com.asesoftware.turnos.controllers;

import com.asesoftware.turnos.models.dto.RequestTurnoDto;
import com.asesoftware.turnos.models.dto.TurnoDto;
import com.asesoftware.turnos.services.ITurnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turno")
@RequiredArgsConstructor
public class TurnoController {

    private final ITurnoService turnoService;

    @GetMapping
    public ResponseEntity<List<TurnoDto>> getTurnoAll() {
        return ResponseEntity.of(Optional.ofNullable(turnoService.getTurnosAll()));
    }

    @PostMapping()
    public ResponseEntity<Boolean> postGenerarTurno(@RequestBody RequestTurnoDto requestTurnoDto){
        return ResponseEntity.of(Optional.ofNullable(turnoService.getGenerarTurno(requestTurnoDto)));
    }
}