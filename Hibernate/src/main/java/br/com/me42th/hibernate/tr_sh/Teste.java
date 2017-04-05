/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.tr_sh;

import br.com.me42th.hibernate.dao.EventoDAO;
import br.com.me42th.hibernate.dao.PalestraDAO;
import br.com.me42th.hibernate.model.Evento;
import br.com.me42th.hibernate.model.Palestra;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Teste {
    public static void main(String[] args) {
        for(Evento e : EventoDAO.consultarTodos())
            System.out.println(e);
        
        /*for(Evento e : EventoDAO.consultarTodos())
            for(Palestra p : e.getPalestras())
                System.out.println("p");
        Evento evento = new Evento();
        List<Palestra> lista = new ArrayList<>();
        int cont = 2;
        evento.setFim(new Date(3000000));
        evento.setInicio(new Date(2000000));
        evento.setNome("Coisas e mais coisas");
        evento.setOrganizazao("Baboseiras ltda");
        Palestra p;
        lista.add(p = PalestraDAO.search(cont++));
        //p.setEvento(evento);
        lista.add(p = PalestraDAO.search(cont++));
        //p.setEvento(evento);
        //lista.add(p = PalestraDAO.search(cont++));
        //p.setEvento(evento);
        //lista.add(p = PalestraDAO.search(cont++));
        //p.setEvento(evento);
        //lista.add(p = PalestraDAO.search(cont++));
        //p.setEvento(evento);
        evento.setPalestras(lista);
        EventoDAO.save(evento);//*/
    }
}
