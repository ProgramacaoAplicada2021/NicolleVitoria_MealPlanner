package com.example.mealplanner.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import com.example.mealplanner.DAO.RefeicaoDAO;
import com.example.mealplanner.R;
import com.example.mealplanner.model.Refeicao;


public class ListaRefeicoesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Cardapio";
   private final  RefeicaoDAO dao = new RefeicaoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_refeicoes);  //colocando o arq estatico q criamos como view dessa activity
        setTitle(TITULO_APPBAR);
        configuraFabNovaRefeicao();
        dao.salva(new Refeicao("almoco", "carne", "arroz", "salada","cenoura"));
        dao.salva(new Refeicao("janta", "carne", "arroz", "salada","cenoura"));
    }

    private void configuraFabNovaRefeicao() {
        FloatingActionButton botaoNovaRefeicao = findViewById(R.id.nova_refeicao);
        botaoNovaRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreAlimentosRefeicaoActivity();
            }
        });
    }

    private void abreAlimentosRefeicaoActivity() {
        startActivity(new Intent(this, AlimentosRefeicaoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraListaRefeicoes();
    }

    private void configuraListaRefeicoes() {
        ListView listaDeRefeicoes = findViewById(R.id.activity_lista_de_refeicoes_listview); //usar listadapter para implementacoes mais complexas
       final List<Refeicao> refeicoes = dao.todos();
        listaDeRefeicoes.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                refeicoes)); //preciso ir adicionando aq no codigo
        listaDeRefeicoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Refeicao refeicaoEscolhida = refeicoes.get(posicao);
               // Log.i("refeicao", "" + refeicaoEscolhida);
                Intent vaiParaAlimentosRefeicaoActivity = new Intent(ListaRefeicoesActivity.this, AlimentosRefeicaoActivity.class);
                vaiParaAlimentosRefeicaoActivity.putExtra("refeicao", refeicaoEscolhida);
                startActivity(vaiParaAlimentosRefeicaoActivity);
            }
        });
    }
}