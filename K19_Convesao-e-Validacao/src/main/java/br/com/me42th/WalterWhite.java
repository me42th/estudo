/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author david
 */
@ManagedBean(name="Heisenberg")
public class WalterWhite {
    private double numero;

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }
}
