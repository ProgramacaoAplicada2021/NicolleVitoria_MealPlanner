package com.example.mealplanner.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mealplanner.R;

public class SubstituicoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substituicoes);
        configuraBotaoPtn();
        configuraBotaoCarbo();
        configuraBotaoHortA();
        configuraBotaoHortB();
        setTitle("Substituições");
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#38A7D8"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

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

    private void configuraBotaoPtn() {
        Button botaoPtn = findViewById(R.id.botao_ptn);
        botaoPtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubstituicoesActivity.this, ProteinaActivity.class));
            }
        });
    }

    private void configuraBotaoCarbo() {
        Button botaoPtn = findViewById(R.id.botao_carbo);
        botaoPtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubstituicoesActivity.this, CarboActivity.class));
            }
        });
    }
    private void configuraBotaoHortA() {
        Button botaoPtn = findViewById(R.id.botao_hortA);
        botaoPtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubstituicoesActivity.this,HortAActivity.class));
            }
        });
    }

    private void configuraBotaoHortB() {
        Button botaoPtn = findViewById(R.id.botao_hortB);
        botaoPtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubstituicoesActivity.this,HortBActivity.class));
            }
        });
    }


}

