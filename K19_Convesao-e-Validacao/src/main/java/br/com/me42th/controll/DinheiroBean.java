/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controll;

import br.com.me42th.model.Dinheiro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author david
 */
@ManagedBean(name="dinheiroBean")
@SessionScoped
public class DinheiroBean {
    private Dinheiro dinheiro = new Dinheiro();

    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }
}
