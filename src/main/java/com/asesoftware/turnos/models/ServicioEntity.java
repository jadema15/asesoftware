package com.asesoftware.turnos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ServicioEntity {

    private Long idServicio;
    private Long idComercio;
    private String nomServicio;
    private DateTimeFormatter horaApertura;
    private DateTimeFormatter horaCierre;
    private Integer duracion;
}
