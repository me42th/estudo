/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controle;

import br.com.me42th.model.Consumidor;
import br.com.me42th.model.Item;
import br.com.me42th.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author david
 */
@SessionScoped
@ManagedBean(name="lojaBean")
public class LojaBean {
   
    private Consumidor atendimento;
    private Produto produto,produtoVisualizar;
    private String busca;
    private List<Produto> resultadoBusca = new ArrayList<>();
    
   
    
    public void addCarrinho(Produto p){
        atendimento.addItem(new Item(p,1));
    }

    public Produto getProdutoVisualizar() {
        return produtoVisualizar;
    }

    public void setProdutoVisualizar(Produto produtoVisualizar) {
        this.produtoVisualizar = produtoVisualizar;
    }

    public List<Produto> getResultadoBusca() {
        return resultadoBusca;
    }

    public void setResultadoBusca(List<Produto> resultadoBusca) {
        this.resultadoBusca = resultadoBusca;
    }


    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public LojaBean(){
        atendimento = new Consumidor();
    }

    public Consumidor getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Consumidor atendimento) {
        this.atendimento = atendimento;
    }

    public String buscaProduto(){
        resultadoBusca = new ArrayList<>();
        for(Produto p : Produto.ESTOQUE)
            if(p.getNome().contains(busca))
                resultadoBusca.add(p);
        return "loja";
    }
    
    public String finalizar(){
        return "finish";
    }
}
    
    

