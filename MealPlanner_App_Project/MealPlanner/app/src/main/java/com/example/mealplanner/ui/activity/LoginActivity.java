package com.example.mealplanner.ui.activity;

import static com.example.mealplanner.ui.activity.ConstantesActivities.CHAVE_REFEICAO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mealplanner.R;
import com.example.mealplanner.model.Refeicao;

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
        //carregaRefeicao();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_alimentos_refeicao_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int itemId = item.getItemId();
//        if (itemId == R.id.activity_alimentos_refeicao_menu_salvar) {
//            finalizaLogin();
//        }
//        return super.onOptionsItemSelected(item);
   // }

//    private void carregaRefeicao() {
//        Intent dados = getIntent();
//        if (dados.hasExtra(CHAVE_REFEICAO)) {
//            setTitle(TITULO_APP_BAR_EDITA_REFEICAO);
//            refeicao = (Refeicao) dados.getSerializableExtra(CHAVE_REFEICAO);
//            preencheCampos();
//        } else {
//            setTitle(TITULO_APP_BAR_NOVA_REFEICAO);
//            refeicao = new Refeicao();
//        }
//    }

//    private void preencheCampos() {
//        campoNome.setText(refeicao.getNome());
//        campoHora.setText(refeicao.getHora());
//        campoPtn.setText(refeicao.getPtn());
//        campoCarbo.setText(refeicao.getCarbo());
//        campoHortA.setText(refeicao.getHortA());
//        campoHortB.setText(refeicao.getHortB());
//    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_login_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ListaRefeicoesActivity.class));
            }
        });
    }

//    private void finalizaLogin() {
////        preencheRefeicao();
////        if (refeicao.temIdValido()) {
////            dao.edita(refeicao);
////        } else {
////            dao.salva(refeicao);
////        }
//        finish();
//    }

    private void inicializacaoLogin() {
        campoUsername = findViewById(R.id.activity_login_username);
        campoEmail = findViewById(R.id.activity_login_email);
        campoAltura = findViewById(R.id.activity_login_altura);
        campoPeso = findViewById(R.id.activity_login_peso);
        campoIdade = findViewById(R.id.activity_login_idade);
        //campoHortA = findViewById(R.id.activity_formulario_refeicao_hortA);
        //campoHortB = findViewById(R.id.activity_formulario_refeicao_hortB);
    }

//    private void salva(Refeicao refeicao) {
//        dao.salva(refeicao);
//        finish(); //retorna ´pra anterior
//    }

    private void preencheRefeicao() {
        String username = campoUsername.getText().toString();
        String email = campoEmail.getText().toString();
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();
        String idade = campoIdade.getText().toString();
        //  Refeicao refeicaoCriada = new Refeicao(nome, ptn, carbo, hortA, hortB);
        //para so atualizar return new Refeicao(nome, ptn, carbo, hortA, hortB);
    }
}