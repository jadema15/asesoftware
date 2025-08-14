package com.asesoftware.turnos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDto {
    private Long idTurno;
    private Date fechaTurno;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;
    private ServicioDto servicio;
}
