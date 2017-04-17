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
public abstract class Animal {
    public abstract String getEspecie();
    public abstract String getIdade();
    private static int cont = 0;
    public Animal(){
        cont++;
    }
    public int getCont(){
        return cont;
    }
}
