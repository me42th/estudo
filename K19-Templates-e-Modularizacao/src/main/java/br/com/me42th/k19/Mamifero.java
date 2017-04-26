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
public class Mamifero extends Animal{
     private String especie, idade;

    public Mamifero(String especie, String idade) {
        this.especie = especie;
        this.idade = idade;
    }
 
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
