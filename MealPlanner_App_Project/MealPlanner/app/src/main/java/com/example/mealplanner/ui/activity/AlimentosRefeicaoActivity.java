package com.example.mealplanner.ui.activity;

import static com.example.mealplanner.ui.activity.ConstantesActivities.CHAVE_REFEICAO;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mealplanner.R;
import com.example.mealplanner.model.Refeicao;
import com.example.mealplanner.DAO.RefeicaoDAO;

public class AlimentosRefeicaoActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR_NOVA_REFEICAO = "Nova Refeição";
    private static final String TITULO_APP_BAR_EDITA_REFEICAO = "Edita Refeição";
    private EditText campoNome;
    private EditText campoPtn;
    private EditText campoCarbo;
    private EditText campoHortA;
    private EditText campoHortB;
    private final RefeicaoDAO dao = new RefeicaoDAO();
    private Refeicao refeicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos_refeicao);
        inicializacaoDosCampos(); //onde entra cada atributo
        configuraBotaoSalvar();
        carregaRefeicao();
    }

    private void carregaRefeicao() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_REFEICAO)) {
            setTitle(TITULO_APP_BAR_EDITA_REFEICAO);
            refeicao = (Refeicao) dados.getSerializableExtra(CHAVE_REFEICAO);
            preencheCampos();
        } else {
            setTitle(TITULO_APP_BAR_NOVA_REFEICAO);
            refeicao = new Refeicao();
        }
    }

    private void preencheCampos() {
        campoNome.setText(refeicao.getNome()); //da pau na hora do floating button
        campoPtn.setText(refeicao.getPtn());
        campoCarbo.setText(refeicao.getCarbo());
        campoHortA.setText(refeicao.getHortA());
        campoHortB.setText(refeicao.getHortB());
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_refeicao_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Refeicao refeicaoCriada = preencheRefeicao();
//                salva(refeicaoCriada);
                finalizaFormulario();
            }

        });
    }


    private void finalizaFormulario() {
        preencheRefeicao();
        if (refeicao.temIdValido()) {
            dao.edita(refeicao);
        } else {
            dao.salva(refeicao);
        }
        finish();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_refeicao_nome);
        campoPtn = findViewById(R.id.activity_formulario_refeicao_ptn);
        campoCarbo = findViewById(R.id.activity_formulario_refeicao_carb);
        campoHortA = findViewById(R.id.activity_formulario_refeicao_hortA);
        campoHortB = findViewById(R.id.activity_formulario_refeicao_hortB);
    }

    private void salva(Refeicao refeicao) {
        dao.salva(refeicao);
        finish(); //retorna ´pra anterior
    }

    private void preencheRefeicao() {
        String nome = campoNome.getText().toString();
        String ptn = campoPtn.getText().toString();
        String carbo = campoCarbo.getText().toString();
        String hortA = campoHortA.getText().toString();
        String hortB = campoHortB.getText().toString();
        refeicao.setNome(nome);
        refeicao.setPtn(ptn);
        refeicao.setCarbo(carbo);
        refeicao.setHortA(hortA);
        refeicao.setHortB(hortB);
        //  Refeicao refeicaoCriada = new Refeicao(nome, ptn, carbo, hortA, hortB);
        //para so atualizar return new Refeicao(nome, ptn, carbo, hortA, hortB);
    }
}