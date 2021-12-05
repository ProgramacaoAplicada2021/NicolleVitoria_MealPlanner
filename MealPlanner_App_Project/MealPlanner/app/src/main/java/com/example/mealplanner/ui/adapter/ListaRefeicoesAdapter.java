package com.example.mealplanner.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mealplanner.R;
import com.example.mealplanner.model.Refeicao;

import java.util.ArrayList;
import java.util.List;

public class ListaRefeicoesAdapter extends BaseAdapter {
    private final List<Refeicao> refeicoes = new ArrayList<>();
    private Context context;

    public ListaRefeicoesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return refeicoes.size();
    }

    @Override
    public Refeicao getItem(int posicao) {
        return refeicoes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return refeicoes.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_refeicao, viewGroup, false);
        Refeicao refeicaoCriada = refeicoes.get(i);
        TextView nome = viewCriada.findViewById(R.id.item_refeicao_nome);
        nome.setText(refeicaoCriada.getHora()+ "h: " +refeicaoCriada.getNome());
        //nome.setText(refeicaoCriada.toString());
//        TextView hora = viewCriada.findViewById(R.id.item_refeicao_hora);
//        hora.setText(refeicaoCriada.getHora());
        TextView ptn = viewCriada.findViewById(R.id.item_refeicao_ptn);
        ptn.setText(refeicaoCriada.getPtnP()+ " g de " +refeicaoCriada.getPtn());
        TextView carbo = viewCriada.findViewById(R.id.item_refeicao_carbo);
        carbo.setText(refeicaoCriada.getCarboP()+ " g de " +refeicaoCriada.getCarbo());
        TextView hortA = viewCriada.findViewById(R.id.item_refeicao_hortA);
        hortA.setText(refeicaoCriada.getHortA());
        TextView hortB = viewCriada.findViewById(R.id.item_refeicao_hortB);
        hortB.setText(refeicaoCriada.getHortBP()+ " g de " +refeicaoCriada.getHortBP());

        return viewCriada;
    }

    public void clear() {
        refeicoes.clear();
    }

    public void addAll(List<Refeicao> refeicoes) {
        this.refeicoes.addAll(refeicoes);
    }

    public void remove(Refeicao refeicao) {
        refeicoes.remove(refeicao);
    }
}
