/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

/**
 *
 * @author david
 */
public class Produto {
    private String nome, codigo;
    private int tamanho;
    private double volume;

    public Produto() {
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Produto))
            return false;
        return ((Produto)obj).getCodigo().equals(this.getCodigo());
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
}
