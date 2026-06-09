package com.example.ExercicioCopaDoMundo.Service;

import com.example.ExercicioCopaDoMundo.Model.Convocacao;
import com.example.ExercicioCopaDoMundo.Model.Selecao;
import com.example.ExercicioCopaDoMundo.Repository.ConvocacaoRepository;
import com.example.ExercicioCopaDoMundo.Repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConvocacaoService {

    private final ConvocacaoRepository convocacaoRepository;
    private final SelecaoRepository selecaoRepository;

    public Convocacao registar(Convocacao convocacao){
        Selecao selecao = selecaoRepository.findById(convocacao.getSelecao().getId())
                .orElseThrow(() -> new RuntimeException("Seleção não encontrada"));
        Integer saldoAtual = selecao.getJogadoresDisponiveis();
        selecao.setJogadoresDisponiveis(saldoAtual + convocacao.getQuantidade());

        selecaoRepository.save(selecao);
        convocacao.setSelecao(selecao);
        return convocacaoRepository.save(convocacao);
    }
}
