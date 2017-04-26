/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.k19;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author david
 *
 */
@ManagedBean(name="animalBean")
public class AnimalBean {
    private List<Animal> lista = new ArrayList<>();

    public AnimalBean() {
        lista.add(new Mamifero("Vaca","8"));
        lista.add(new Reptil("Lagartixa","6"));
        lista.add(new Ave("Galinha","3"));
        lista.add(new Mamifero("Cachorro","4"));
        lista.add(new Reptil("Cobra","3"));
        lista.add(new Ave("Aguia","6"));
        lista.add(new Mamifero("Gato","4"));
        lista.add(new Reptil("Jacare","6"));
        lista.add(new Ave("Pinguim","5"));
        
    }

    public List<Animal> getLista() {
        return lista;
    }

    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }
    
}
