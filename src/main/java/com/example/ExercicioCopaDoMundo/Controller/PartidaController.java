package com.example.ExercicioCopaDoMundo.Controller;

import com.example.ExercicioCopaDoMundo.Model.Partida;
import com.example.ExercicioCopaDoMundo.Repository.PartidaRespository;
import com.example.ExercicioCopaDoMundo.Service.PartidaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaRespository partidaRespository;
    private final PartidaService partidaService;

    @GetMapping
    public List<Partida> listar(){
        return partidaRespository.findAllByOrderBydataPartidaDesc();
    }

    @PostMapping
    public ResponseEntity<Partida> registrar (@Valid @RequestBody Partida partida){
        return ResponseEntity.status(201).body(partidaService.registrar(partida));
    }
}
