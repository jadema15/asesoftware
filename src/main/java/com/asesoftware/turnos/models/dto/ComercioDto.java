package com.asesoftware.turnos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComercioDto {

    private Long idComercio;
    private String nomComercio;
    private Integer aforoMaximo;
}
