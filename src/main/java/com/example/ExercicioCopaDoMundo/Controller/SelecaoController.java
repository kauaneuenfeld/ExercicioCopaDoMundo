package com.example.ExercicioCopaDoMundo.Controller;

import com.example.ExercicioCopaDoMundo.Model.Selecao;
import com.example.ExercicioCopaDoMundo.Repository.SelecaoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selecoes")
@RequiredArgsConstructor
public class SelecaoController {

    private final SelecaoRepository selecaoRepository;

    @GetMapping
    public List<Selecao> listar() {
        return selecaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Selecao> cadastrar(@Valid @RequestBody Selecao selecao) {
        return ResponseEntity.status(201).body(selecaoRepository.save(selecao));
    }

    @GetMapping("/grupo")
    public List<Selecao> ListarPorGrupo(){
        return selecaoRepository.findAllOrderByGrupo();
    }

    @GetMapping("/limites")
    public List<Selecao> ListarNosLimites(){
        return selecaoRepository.findByJogadoresDisponiveisLessThanEqualOrJogadoresDisponiveisGreaterThanEqual(0,100);
    }
}
