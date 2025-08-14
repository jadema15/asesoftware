package com.asesoftware.turnos.models.dto;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class RequestTurnoDto {

    private Timestamp fechaInicio;
    private Timestamp  fechaFin;
    private Long idServicio;
}
