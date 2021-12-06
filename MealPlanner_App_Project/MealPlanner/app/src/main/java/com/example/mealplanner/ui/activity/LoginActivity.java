package com.example.mealplanner.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mealplanner.R;

public class LoginActivity extends AppCompatActivity {

    private EditText campoUsername;
    private EditText campoPeso;
    private EditText campoAltura;
    private EditText campoEmail;
    private EditText campoIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        inicializacaoLogin(); //onde entra cada atributo
        configuraBotaoSalvar();
        setTitle("MealPlanner");
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



    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_login_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ListaRefeicoesActivity.class));
            }
        });
    }



    private void inicializacaoLogin() {
        campoUsername = findViewById(R.id.activity_login_username);
        campoEmail = findViewById(R.id.activity_login_email);
        campoAltura = findViewById(R.id.activity_login_altura);
        campoPeso = findViewById(R.id.activity_login_peso);
        campoIdade = findViewById(R.id.activity_login_idade);
        //campoHortA = findViewById(R.id.activity_formulario_refeicao_hortA);
        //campoHortB = findViewById(R.id.activity_formulario_refeicao_hortB);
    }




}