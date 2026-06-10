package com.example.ExercicioCopaDoMundo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class SelecaoGrupoDTO {

    private String grupo;
    private BigDecimal valorTotal;
}
