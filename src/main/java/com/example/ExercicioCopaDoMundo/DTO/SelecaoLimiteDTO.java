package com.example.ExercicioCopaDoMundo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SelecaoLimiteDTO {

    private String nomeSelecao;
    private Integer jogadoresDisponiveis;
    private String tipoLimite;
    private Double percentualNivel;
}
