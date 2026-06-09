package com.example.ExercicioCopaDoMundo.Service;

import com.example.ExercicioCopaDoMundo.Model.Partida;
import com.example.ExercicioCopaDoMundo.Model.Selecao;
import com.example.ExercicioCopaDoMundo.Repository.PartidaRespository;
import com.example.ExercicioCopaDoMundo.Repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartidaService {

    private final PartidaRespository partidaRespository;
    private final SelecaoRepository selecaoRepository;

    public Partida registrar(Partida partida) {
        Selecao selecao = selecaoRepository.findById(partida.getSelecao().getId())
                .orElseThrow(() -> new RuntimeException("Seleção não encontrada"));

        if (selecao.getJogadoresDisponiveis() < partida.getQuantidade()) {
            throw new RuntimeException("Quantidade indisponivel de jogadores");
        }
        selecao.setJogadoresDisponiveis(selecao.getJogadoresDisponiveis() - partida.getQuantidade());

        selecaoRepository.save(selecao);
        partida.setSelecao(selecao);
        return partidaRespository.save(partida);

    }
}
