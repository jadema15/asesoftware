package com.asesoftware.turnos.models.dto;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TurnoDto {
    private Long idTurno;
    private Long idServicio;
    private Date fechaTurno;
    private Date fechaInicio;
    private DateTimeFormatter horaInicio;
    private DateTimeFormatter horaFin;
    private String estado;
}
