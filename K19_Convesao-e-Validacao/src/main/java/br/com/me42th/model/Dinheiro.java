/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.util.Date;

/**
 *
 * @author david
 */
public class Dinheiro {
    private double perc,real,resultado;
    private Date data;

    public double getPerc() {
        return perc;
    }

    public void setPerc(double perc) {
        this.perc = perc;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getResultado() {
        if(perc != 0 && real != 0)
            resultado = (perc*real)+real;
        return resultado;
    }

    
        
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
