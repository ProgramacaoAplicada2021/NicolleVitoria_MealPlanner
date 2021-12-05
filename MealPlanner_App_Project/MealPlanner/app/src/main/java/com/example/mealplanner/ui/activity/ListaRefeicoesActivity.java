package com.example.mealplanner.ui.activity;

import static com.example.mealplanner.ui.activity.ConstantesActivities.CHAVE_REFEICAO;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mealplanner.ui.adapter.ListaRefeicoesAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.mealplanner.DAO.RefeicaoDAO;
import com.example.mealplanner.R;
import com.example.mealplanner.model.Refeicao;

import java.util.ArrayList;
import java.util.List;


public class ListaRefeicoesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Minhas refeições";
    private final RefeicaoDAO dao = new RefeicaoDAO();
    private ListaRefeicoesAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_refeicoes);  //colocando o arq estatico q criamos como view dessa activity
        setTitle(TITULO_APPBAR);
        configuraFabNovaRefeicao();
        configuraListaRefeicoes();
        //dao.salva(new Refeicao("almoco", "12h", "carne", "arroz", "salada", "cenoura", "carne", "arroz", "salada", "cenoura"));
        //dao.salva(new Refeicao("janta", "20h", "carne", "arroz", "salada", "cenoura"));
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_de_refeicoes_menu, menu); //menu.add("Remover");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_alunos_menu_remover) {
            AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Refeicao refeicaoEscolhida = adapter.getItem(menuInfo.position);
            remove(refeicaoEscolhida);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_lista_de_refeicoes_substituicao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_de_refeicoes_substituicao) {
            startActivity(new Intent(this, SubstituicoesActivity.class));
        }
        return super.onOptionsItemSelected(item);
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

        adapter = new ListaRefeicoesAdapter(this);
        listaDeRefeicoes.setAdapter(adapter);
    }
}