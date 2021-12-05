package com.example.mealplanner.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mealplanner.R;

public class SubstituicoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substituicoes);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_substituicao_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_substituicao_voltar) {
            startActivity(new Intent(SubstituicoesActivity.this, ListaRefeicoesActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }



//        Button botaoPtn = findViewById(R.id.botao_ptn);
//        botaoPtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SubstituicoesActivity.this, ProteinaActivity.class));
//            }
//        });


    //        Button botaoCarbo = findViewById(R.id.botao_carbo);
//        botaoCarbo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SubstituicoesActivity.this, CarboidratoActivity.class));
//            }
//        });



    //        Button botaoHortA = findViewById(R.id.botao_hortA);
//        botaoHortA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SubstituicoesActivity.this, HortAActivity.class));
//            }
//        });


    //        Button botaoHortB = findViewById(R.id.botao_hortB);
//        botaoHortB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SubstituicoesActivity.this, HortBActivity.class));
//            }
//        });





    }

