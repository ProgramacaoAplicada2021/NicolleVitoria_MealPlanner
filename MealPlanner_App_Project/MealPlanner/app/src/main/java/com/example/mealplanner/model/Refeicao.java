package com.example.mealplanner.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Refeicao implements Serializable {
    private int id=0;
    private  String nome;
    private String hora;
    private  String ptn;
    private  String carbo;
    private  String hortA;
    private  String hortB;
    private String ptnP;
    private  String carboP;
    private  String hortAP;
    private  String hortBP;


    public Refeicao(String nome, String hora, String ptn, String carbo, String hortA, String hortB,
                    String ptnP, String carboP, String hortAP, String hortBP) {
        this.nome = nome;
        this.hora = hora;
        this.ptn = ptn;
        this.carbo = carbo;
        this.hortA = hortA;
        this.hortB = hortB;
        this.ptnP = ptnP;
        this.carboP = carboP;
        this.hortAP = hortAP; //NAO EH NECESSARIO
        this.hortBP = hortBP;
    }

    public Refeicao() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setPtn(String ptn) {
        this.ptn = ptn;
    }
    public void setCarbo(String carbo) {
        this.carbo = carbo;
    }
    public void setHortA(String hortA) {
        this.hortA = hortA;
    }
    public void setHortB(String hortB) {
        this.hortB = hortB;
    }
    public void setPtnP(String ptnP) {
        this.ptnP = ptnP;
    }
    public void setCarboP(String carboP) {
        this.carboP = carboP;
    }
    public void setHortBP(String hortBP) {
        this.hortBP = hortBP;
    }

    public String getNome() {
        return nome;
    }
    public String getHora() {
        return hora;
    }

    public String getPtn() {
        return ptn;
    }

    public String getCarbo() {
        return carbo;
    }

    public String getHortA() {
        return hortA;
    }

    public String getHortB() {
        return hortB;
    }

    public String getPtnP() { //P DE PORÇAO
        return ptnP;
    }

    public String getCarboP() {
        return carboP;
    }

    public String getHortAP() {
        return hortAP;
    }

    public String getHortBP() {
        return hortBP;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " - " + hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;
    }
}
