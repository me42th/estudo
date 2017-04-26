/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controll;

import br.com.me42th.model.RCI;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author david
 */
@ManagedBean(name="rci")
@SessionScoped
public class RCIBean {
    private List<RCI> lista = new ArrayList<>();
    private RCI temp;

    public List<RCI> getLista() {
        return lista;
    }
    
    public void addRCI(){
        if(!lista.contains(temp))
            lista.add(temp);
        else{
            FacesMessage msg = new FacesMessage("Apenas uma entrada por registro, informe outro valor");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        temp = null;
    }
    
    public void rmvRCI(RCI temp){
        if(lista.contains(temp))
            lista.remove(temp);
    }
    
    public void setLista(List<RCI> lista) {
        this.lista = lista;
    }

    public RCI getTemp() {
        return temp;
    }

    public void setTemp(RCI temp) {
        this.temp = temp;
    }
    
}
