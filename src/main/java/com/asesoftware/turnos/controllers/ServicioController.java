package com.asesoftware.turnos.controllers;

import com.asesoftware.turnos.models.dto.ServicioDto;
import com.asesoftware.turnos.services.IServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicio")
@RequiredArgsConstructor
public class ServicioController {

    private final IServicioService servicio;
    @GetMapping
    public ResponseEntity<List<ServicioDto>> getServicioAll(){
        return ResponseEntity.of(Optional.ofNullable(servicio.getServicioAll()));
    }
}