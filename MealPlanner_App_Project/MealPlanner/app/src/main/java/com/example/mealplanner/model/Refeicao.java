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

    public Refeicao(String nome, String hora, String ptn, String carbo, String hortA, String hortB) {
        this.nome = nome;
        this.ptn = ptn;
        this.carbo = carbo;
        this.hortA = hortA;
        this.hortB = hortB;
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
