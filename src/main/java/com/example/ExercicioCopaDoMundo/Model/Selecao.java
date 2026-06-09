package com.example.ExercicioCopaDoMundo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Selecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatorio")
    private String nome;

    @NotBlank(message = "O grupo é obrigatorio")
    private String grupo;

    private String fase;

    @Min(value = 0, message = "Gols marcados nao pode ser negativo")
    private Integer golsMarcados;

    @Min(value = 0, message = "Gols sofridos não pode ser negativo")
    private Integer golsSofridos;

    @Positive(message = "O valor do platel deve ser postivo")
    private Double valorPlantel;

    private Integer jogadoresDisponiveis = 0;
}
