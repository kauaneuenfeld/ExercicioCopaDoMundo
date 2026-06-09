package com.example.ExercicioCopaDoMundo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Convocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataConvocacao;

    @Positive(message = "A quantidade deve ser maior que sero")
    private Integer quantidade;

    @ManyToOne
    private Selecao selecao;
}
