package com.asesoftware.turnos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Table(name="servicios")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio", nullable = false)
    private Long idServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comercio", nullable = false)
    private ComercioEntity comercio;

    @Column(name="nom_servicio")
    private String nomServicio;

    @Column(name="hora_apertura")
    private LocalTime horaApertura;

    @Column(name="hora_cierre")
    private LocalTime horaCierre;

    @Column(name="duracion")
    private Integer duracion;
}
