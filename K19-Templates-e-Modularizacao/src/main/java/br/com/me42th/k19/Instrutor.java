/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.k19;

/**
 *
 * @author david
 */
public class Instrutor {
    private String nome, dataNascimento;

    public Instrutor(String nome) {
        this.nome = nome;
        this.dataNascimento = ""+((int)(Math.random()*28))+"/"
                             +((int)(Math.random()*12))+"/"
                             +((int)(Math.random()*50+1950));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
