package com.example.mealplanner.ui.activity;

import static com.example.mealplanner.ui.activity.ConstantesActivities.CHAVE_REFEICAO;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mealplanner.DAO.RefeicaoDAO;
import com.example.mealplanner.R;
import com.example.mealplanner.model.Refeicao;


public class ListaRefeicoesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Cardapio";
    private final RefeicaoDAO dao = new RefeicaoDAO();
    private ArrayAdapter<Refeicao> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_refeicoes);  //colocando o arq estatico q criamos como view dessa activity
        setTitle(TITULO_APPBAR);
        configuraFabNovaRefeicao();
        configuraListaRefeicoes();
        dao.salva(new Refeicao("almoco", "carne", "arroz", "salada", "cenoura"));
        dao.salva(new Refeicao("janta", "carne", "arroz", "salada", "cenoura"));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Remover");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Refeicao refeicaoEscolhida = adapter.getItem(menuInfo.position);
        remove(refeicaoEscolhida);
        return super.onContextItemSelected(item);
    }

    private void configuraFabNovaRefeicao() {
        FloatingActionButton botaoNovaRefeicao = findViewById(R.id.nova_refeicao);
        botaoNovaRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioModoInsereRefeicao();
            }
        });
    }

    private void abreFormularioModoInsereRefeicao() {
        startActivity(new Intent(this, AlimentosRefeicaoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaRefeicoes();
    }

    private void atualizaRefeicoes() {
        adapter.clear();
        adapter.addAll(dao.todos());
    }

    private void configuraListaRefeicoes() {
        ListView listaDeRefeicoes = findViewById(R.id.activity_lista_de_refeicoes_listview); //usar listadapter para implementacoes mais complexas
        configuraAdapter(listaDeRefeicoes); //preciso ir adicionando aq no codigo
        configuraListenerDeClickPorItem(listaDeRefeicoes);
        //configuraListenerDeClickLongoPorItem(listaDeRefeicoes);
        registerForContextMenu(listaDeRefeicoes); //indica que a lista tem um registro de context menu

    }

//    private void configuraListenerDeClickLongoPorItem(ListView listaDeRefeicoes) {
//        listaDeRefeicoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
//               // Log.i("clicklongo", String.valueOf((posicao)));
//                Refeicao refeicaoEscolhida = (Refeicao) adapterView.getItemAtPosition(posicao);
//                remove(refeicaoEscolhida);
//                return true;
//            }
//        });
//    }

    private void remove(Refeicao refeicao) {
        dao.remove(refeicao);
        adapter.remove(refeicao);
    }

    private void configuraListenerDeClickPorItem(ListView listaDeRefeicoes) {
        listaDeRefeicoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Refeicao refeicaoEscolhida = (Refeicao) adapterView.getItemAtPosition(posicao);
                // Log.i("refeicao", "" + refeicaoEscolhida);
                abreFormularioModoEditaRefeicao(refeicaoEscolhida);
            }
        });
    }

    private void abreFormularioModoEditaRefeicao(Refeicao refeicao) {
        Intent vaiParaAlimentosRefeicaoActivity = new Intent(ListaRefeicoesActivity.this, AlimentosRefeicaoActivity.class);
        vaiParaAlimentosRefeicaoActivity.putExtra(CHAVE_REFEICAO, refeicao);
        startActivity(vaiParaAlimentosRefeicaoActivity);
    }

    private void configuraAdapter(ListView listaDeRefeicoes) {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1);
        listaDeRefeicoes.setAdapter(adapter);
    }
}