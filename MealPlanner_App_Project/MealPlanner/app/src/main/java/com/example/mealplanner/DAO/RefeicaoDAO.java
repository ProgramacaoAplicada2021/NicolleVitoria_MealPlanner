package com.example.mealplanner.DAO;

import androidx.annotation.Nullable;

import com.example.mealplanner.model.Refeicao;

import java.util.ArrayList;
import java.util.List;

public class RefeicaoDAO {

    private final static List<Refeicao> refeicoes = new ArrayList<>();
    private static int contadorDeids = 1;

    public void salva(Refeicao refeicao) {
        refeicao.setId(contadorDeids);
        refeicoes.add(refeicao);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeids++;
    }

    public void edita(Refeicao refeicao) {
        Refeicao refeicaoEncontrada = buscaRefeicaoPeloId(refeicao);
        if (refeicaoEncontrada != null) {
            int posicaoDaRefeicao = refeicoes.indexOf(refeicaoEncontrada);
            refeicoes.set(posicaoDaRefeicao, refeicao);
        }
    }

    @Nullable
    private Refeicao buscaRefeicaoPeloId(Refeicao refeicao) {
        for (Refeicao a :
                refeicoes) {
            if (a.getId() == refeicao.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Refeicao> todos() {

        return new ArrayList<>(refeicoes);
    }


    public void remove(Refeicao refeicao) {
        Refeicao refeicaoDevolvida = buscaRefeicaoPeloId(refeicao);
       if(refeicaoDevolvida != null){
           refeicoes.remove(refeicaoDevolvida);
       }
    }
}
