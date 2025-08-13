package com.asesoftware.turnos.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turno")
@AllArgsConstructor
public class TurnoController {

    @GetMapping
    public String getTurnoAll(){
        return "coemrcio";
    }
}
