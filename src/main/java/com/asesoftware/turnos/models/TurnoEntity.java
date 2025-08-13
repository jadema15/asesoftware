package com.asesoftware.turnos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TurnoEntity {
    private Long idTurno;
    private Long idServicio;
    private Date fechaTurno;
    private Date fechaInicio;
    private DateTimeFormatter horaInicio;
    private DateTimeFormatter horaFin;
    private String estado;
}
