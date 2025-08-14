package com.asesoftware.turnos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDto {

    private Long idServicio;
    private String nomServicio;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Integer duracion;
    private ComercioDto comercio;
}
