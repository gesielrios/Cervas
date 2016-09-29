package br.edu.febac.cervas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by gesie on 03/09/2016.
 */
public class Bebida implements Serializable {

    private int id;
    private String nome;
    private int quantidade;
    private BigDecimal valor;
    private BigDecimal custo;
    private int imagemID;

    public Bebida (String nome, BigDecimal valor, int quantidade, int imagemID) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.imagemID = imagemID;
        calculaCusto();
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

    public BigDecimal getValor() {
        return valor;
    }


    public BigDecimal getCusto() {
        return custo;
    }

    public void calculaCusto() {
        this.custo = this.valor.divide(new BigDecimal(this.quantidade), 4, BigDecimal.ROUND_UP);
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.quantidade + " ml";
    }

    public BigDecimal getCustoPorLivro() {
        return this.custo.multiply(new BigDecimal("1000"), MathContext.DECIMAL64);
    }

    public int getImagemID() {
        return this.imagemID;
    }
}
