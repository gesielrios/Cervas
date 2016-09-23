package br.edu.febac.cervas.model;

import java.io.Serializable;

/**
 * Created by gesie on 03/09/2016.
 */
public class Bebida implements Serializable {

    private int id;
    private String nome;
    private int quantidade;
    private float valor;
    private float custo;
    private int imagemID;

    public Bebida (String nome, float valor, int quantidade, int imagemID) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.imagemID = imagemID;
        setCusto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValor() {
        return valor;
    }


    public float getCusto() {
        return custo;
    }

    public void setCusto() {
        this.custo = this.valor / this.quantidade;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.quantidade + " ml";
    }

    public float getCustoPorLivro() {
        return custo * 1000;
    }

    public int getImagemID() {
        return this.imagemID;
    }
}
