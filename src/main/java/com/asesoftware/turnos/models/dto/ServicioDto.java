package com.asesoftware.turnos.models.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ServicioDto {

    private Long idServicio;
    private Long idComercio;
    private String nomServicio;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Integer duracion;
}
