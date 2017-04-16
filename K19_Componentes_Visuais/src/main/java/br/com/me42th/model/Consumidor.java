/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class Consumidor {
    
    private List<Item> carrinho = new ArrayList<>();
    private Double total = 0.0;
    private String totalF;
    
    public List<Item> getCarrinho() {
        return carrinho;
    }
    
    public void addItem(Item e){
       totalF = new DecimalFormat("R$ 0.##")
               .format(
               total+= e.getProduto().getPreco()*e.getQuantidade()
               );
       if(carrinho.contains(e))
           carrinho.get(carrinho.indexOf(e)).setQuantidade(
                   carrinho.get(carrinho.indexOf(e)).getQuantidade()+e.getQuantidade()
           );
       carrinho.add(e);
    }
    
    public void rmvItem(Item e){
       if(!carrinho.contains(e))
         return;   
       carrinho.remove(e);
       totalF = new DecimalFormat("R$ 0.##").format(total);
       }

    public String getTotalF() {
        return totalF;
    }

    public void setTotalF(String totalF) {
        this.totalF = totalF;
    }
    
    
    public void setCarrinho(List<Item> carrinho) {
        this.carrinho = carrinho;
    }

    public Double getTotal() {
        return total;
    }

    
    
    public void setTotal(Double total) {
        this.total = total;
    }
}
