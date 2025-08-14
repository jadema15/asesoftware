package com.asesoftware.turnos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Table(name="turnos")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TurnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno", nullable = false)
    private Long idTurno;

    @Column(name="id_servicio")
    private Long idServicio;

    @Column(name="fecha_turno")
    private Date fechaTurno;

    @Column(name="hora_inicio")
    private LocalTime horaInicio;

    @Column(name="hora_fin")
    private LocalTime horaFin;

    @Column(name="estado")
    private String estado;
}
