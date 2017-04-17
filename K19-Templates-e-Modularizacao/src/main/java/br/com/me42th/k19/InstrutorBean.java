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
 */
@ManagedBean(name="instrutorBean")
public class InstrutorBean {
    private List<Instrutor> instrutores;
    
    public InstrutorBean() {
    
    instrutores = new ArrayList<>();
    instrutores.add(new Instrutor("David"));
    instrutores.add(new Instrutor("Natty"));
    instrutores.add(new Instrutor("Murilo"));
    instrutores.add(new Instrutor("Evandro"));
    instrutores.add(new Instrutor("Ceinha"));
    
    }
    
        
    
    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(List<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }
    
}
