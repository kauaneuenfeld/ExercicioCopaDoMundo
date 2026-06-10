package com.example.ExercicioCopaDoMundo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class HistoricoDTO {

    private String nomeSelecao;
    private String grupo;
    private Long totalConvocacoes;
    private Long totalPartida;
    private Long saldoPeriodo;
    private BigDecimal valorTotalConvocacoes;
    private BigDecimal valorTotalPartidas;
}
