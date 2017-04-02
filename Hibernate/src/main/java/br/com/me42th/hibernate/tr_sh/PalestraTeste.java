/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.tr_sh;

import br.com.me42th.hibernate.dao.PalestraDAO;
import br.com.me42th.hibernate.model.Local;
import br.com.me42th.hibernate.model.Palestra;
import java.util.Date;


/**
 *
 * @author david
 */
public class PalestraTeste {
    public static void main(String[] args) {
        
    //==>INSERT
        /*
        Palestra p = new Palestra();
        //Date(int year, int month, int date, int hrs, int min)
        p.setDataHora(new Date(10000));
        p.setDuracao(0);
        //p.setId(0);
        p.setTitulo("Programacao orientada a gambiarra");
        Local l = new Local();
        l.setCapacidade(42);
        l.setPredio("Floresta");
        l.setSala("Quarto de lilo");
        l.setId(4);
        p.setLocal(l);
        System.out.println(":|");
        PalestraDAO.save(p);
        System.out.println(":)");
        */
    //==>Delete
        /*
        System.out.println(":|");
        PalestraDAO.remove(1);
        System.out.println(":)");
        */
    ////==>Select
        /*
        Palestra p = PalestraDAO.search(2);
        System.out.println(p);
        */
    }
}
