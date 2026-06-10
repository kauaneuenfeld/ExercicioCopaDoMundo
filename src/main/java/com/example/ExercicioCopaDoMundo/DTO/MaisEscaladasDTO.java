package com.example.ExercicioCopaDoMundo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class MaisEscaladasDTO {

    private String nomeSelecao;
    private Long quantidadeTotalEscalada;
    private BigDecimal valorTotalPartidas;
}
