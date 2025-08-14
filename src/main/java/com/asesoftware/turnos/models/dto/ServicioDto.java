package com.asesoftware.turnos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDto {

    private Long idServicio;
    private Long idComercio;
    private String nomServicio;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Integer duracion;
}
