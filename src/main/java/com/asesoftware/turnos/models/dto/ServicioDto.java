package com.asesoftware.turnos.models.dto;

import java.time.format.DateTimeFormatter;

public class ServicioDto {

    private Long idServicio;
    private Long idComercio;
    private String nomServicio;
    private DateTimeFormatter horaApertura;
    private DateTimeFormatter horaCierre;
    private Integer duracion;
}
