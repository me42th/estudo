/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.tr_sh;

import br.com.me42th.hibernate.dao.LocalDAO;
import br.com.me42th.hibernate.dao.PalestraDAO;
import br.com.me42th.hibernate.model.Palestra;
import br.com.me42th.hibernate.model.Palestrante;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *
 * @author david
 */
public class PalestraTeste {
    public static void main(String[] args) {
    
    Palestra p = new Palestra();
    p.setDataHora(new Date(5000));
    p.setDuracao(0);
    p.setLocal(LocalDAO.search(9));
    List<Palestrante> lista = new ArrayList<>();
    Palestrante pa = new Palestrante();
    pa.setId(1);
    lista.add(pa);
    p.setPalestrantes(lista);
    PalestraDAO.save(p);
    System.out.println(PalestraDAO.search(3)+"\n \t "+ PalestraDAO.search(3).getPalestrantes().get(0));
    System.out.println(PalestraDAO.search(4)+"\n \t "+ PalestraDAO.search(4).getPalestrantes().get(0)+
                                             "\n \t "+ PalestraDAO.search(4).getPalestrantes().get(1));
    
    //==>Insert && OneToMany && ManyToOne    
    /*Palestrante p = new Palestrante();
        p.setMinibio("Alguem 1");
        p.setNome("Fulano");
        p.setPalestra(PalestraDAO.search(2));
    PalestranteDAO.save(p);
    p = new Palestrante();
        p.setMinibio("Alguem 2");
        p.setNome("Cicrano");
        p.setPalestra(PalestraDAO.search(2));
    PalestranteDAO.save(p);
    p = new Palestrante();
        p.setMinibio("Alguem 3");
        p.setNome("Beltrano");
        p.setPalestra(PalestraDAO.search(2));
    PalestranteDAO.save(p);
    p = new Palestrante();
        p.setMinibio("Alguem 4");
        p.setNome("Estroncio");
        p.setPalestra(PalestraDAO.search(2));
    PalestranteDAO.save(p);
    p = new Palestrante();
        p.setMinibio("Alguem 5");
        p.setNome("Jaonilcion");
        p.setPalestra(PalestraDAO.search(2));
    PalestranteDAO.save(p);
    p = new Palestrante();
        p.setMinibio("Alguem 6");
        p.setNome("Laraublides");
        p.setPalestra(PalestraDAO.search(2));
    PalestranteDAO.save(p);
    */
    }
}
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
    //==>Select
        /*
        Palestra p = PalestraDAO.search(2);
        System.out.println(p);
        */