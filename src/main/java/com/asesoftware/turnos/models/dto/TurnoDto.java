package com.asesoftware.turnos.models.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class TurnoDto {
    private Long idTurno;
    private Long idServicio;
    private Date fechaTurno;
    private Date fechaInicio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;
}
