package com.asesoftware.turnos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Table(name="servicios")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio", nullable = false)
    private Long idServicio;

    @Column(name="id_comercio")
    private Long idComercio;

    @Column(name="nom_servicio")
    private String nomServicio;

    @Column(name="hora_apertura")
    private LocalTime horaApertura;

    @Column(name="hora_cierre")
    private LocalTime horaCierre;

    @Column(name="duracion")
    private Integer duracion;
}
