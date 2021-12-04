package com.example.mealplanner.DAO;

import com.example.mealplanner.R;
import com.example.mealplanner.model.Refeicao;

import java.util.ArrayList;
import java.util.List;

public class RefeicaoDAO {

    private final static List<Refeicao> refeicoes = new ArrayList<>();
    private static int contadorDeids = 1;

    public void salva(Refeicao refeicao) {
        refeicao.setId(contadorDeids);
        refeicoes.add(refeicao);
        contadorDeids++;

    }

    public void edita(Refeicao refeicao) {
        Refeicao refeicaoEncontrada = null;
        for (Refeicao a :
                refeicoes) {
            if (a.getId() == refeicao.getId()) {

                refeicaoEncontrada = a;

            }
        }
        if (refeicaoEncontrada != null) {
            int posicaoDaRefeicao = refeicoes.indexOf(refeicaoEncontrada);
            refeicoes.set(posicaoDaRefeicao, refeicao);
        }
    }

    public List<Refeicao> todos() {

        return new ArrayList<>(refeicoes);
    }
}
