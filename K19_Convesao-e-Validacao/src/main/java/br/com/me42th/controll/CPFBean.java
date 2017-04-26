/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controll;

import br.com.me42th.model.CPF;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="cad_cpf")
@SessionScoped
public class CPFBean {
    private List<CPF> lista = new ArrayList<>();
    private CPF temp;
    
    public void addCPF(){
        if(!lista.contains(temp))
            lista.add(temp);
        temp = null;
    }
    
    public void rmvCPF(CPF temp){
        if(lista.contains(temp))
            lista.remove(
                    lista.get(
                            lista.indexOf(temp)
                    )
            );
    }
    
    public List<CPF> getLista() {
        return lista;
    }

    public void setLista(List<CPF> lista) {
        this.lista = lista;
    }

    public CPF getTemp() {
        return temp;
    }

    public void setTemp(CPF temp) {
        this.temp = temp;
    }
}
