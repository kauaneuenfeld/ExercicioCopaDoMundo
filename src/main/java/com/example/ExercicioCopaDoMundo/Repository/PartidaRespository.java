package com.example.ExercicioCopaDoMundo.Repository;

import com.example.ExercicioCopaDoMundo.Model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PartidaRespository extends JpaRepository<Partida, Long> {
    List<Partida> findAllByOrderBydataPartidaDesc();

    List<Partida> findByDataPartidaBetweenOrderByDataPartidaAsc(LocalDate dataInicial, LocalDate dataFinal);

    @Query("SELECT p FROM Partida p " + "WHERE p.dataPartida BETWEEN :dataIncicial AND :dataFinal " + "ORDER BY p.quantidade DESC")
    List<Partida> findMaisEscaladasNoPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal);
}
