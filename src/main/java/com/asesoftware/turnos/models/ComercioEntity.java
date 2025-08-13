package com.asesoftware.turnos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ComercioEntity {

    private Long idComercio;
    private String nomComercio;
    private Integer aforoMaximo;
}
