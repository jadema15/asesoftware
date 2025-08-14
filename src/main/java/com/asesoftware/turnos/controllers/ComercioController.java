package com.asesoftware.turnos.controllers;

import com.asesoftware.turnos.models.dto.ComercioDto;
import com.asesoftware.turnos.services.IComercioService;
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
public class ComercioController {

    private final IComercioService comercio;
    @GetMapping
    public ResponseEntity<List<ComercioDto>> getComercioAll(){
        return ResponseEntity.of(Optional.ofNullable(comercio.getComercioAll()));
    }
}
