package com.example.ExercicioCopaDoMundo.Controller;

import com.example.ExercicioCopaDoMundo.Model.Partida;
import com.example.ExercicioCopaDoMundo.Repository.PartidaRespository;
import com.example.ExercicioCopaDoMundo.Service.PartidaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/partidas")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaRespository partidaRespository;
    private final PartidaService partidaService;

    @GetMapping
    public List<Partida> listar() {
        return partidaRespository.findAllByOrderByDataPartidaDesc();
    }

    @PostMapping
    public ResponseEntity<Partida> registrar(@Valid @RequestBody Partida partida) {
        return ResponseEntity.status(201).body(partidaService.registrar(partida));
    }

    @GetMapping("/historico")
    public List<Partida> historico(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return partidaRespository.findByDataPartidaBetweenOrderByDataPartidaAsc(dataInicial, dataFinal);
    }

    @GetMapping("/mais-escaladas")
    public List<Partida> maisEscaladas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return partidaRespository.findMaisEscaladasNoPeriodo(dataInicial, dataFinal);
    }
}