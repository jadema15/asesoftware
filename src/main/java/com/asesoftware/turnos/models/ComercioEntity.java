package com.asesoftware.turnos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="comercios")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComercioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comercio", nullable = false)
    private Long idComercio;

    @Column(name="nombre_comercio")
    private String nomComercio;

    @Column(name="aforo_maximo")
    private Integer aforoMaximo;

}
