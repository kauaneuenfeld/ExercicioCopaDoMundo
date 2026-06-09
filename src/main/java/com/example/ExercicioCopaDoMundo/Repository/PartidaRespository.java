package com.example.ExercicioCopaDoMundo.Repository;

import com.example.ExercicioCopaDoMundo.Model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRespository extends JpaRepository<Partida, Long> {
    List<Partida> findAllByOrderBydataPartidaDesc();
}
