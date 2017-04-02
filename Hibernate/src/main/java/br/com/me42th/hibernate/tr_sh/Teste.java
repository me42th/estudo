/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.tr_sh;

import br.com.me42th.hibernate.dao.LocalDAO;
import br.com.me42th.hibernate.model.Local;


public class Teste {
    public static void main(String[] args) {
        Local l = new Local();
        l.setCapacidade(42);
        l.setPredio("Um valor qualquer");
        l.setSala("Imagine");
        System.out.println(":|");
        LocalDAO.save(l);
        System.out.println(":)");
    }
}
