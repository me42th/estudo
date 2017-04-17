/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controll;

import br.com.me42th.model.Produto;
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
@SessionScoped
@ManagedBean(name="estoque")
public class ProdutoBean {
    private List<Produto> itens = new ArrayList<>();
    private Produto produto = new Produto();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void addProduto(){
        if(itens.contains(produto)){
            FacesMessage mensagem = new FacesMessage("Produto já cadastrado!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
        }
        itens.add(produto);
        FacesMessage mensagem = new FacesMessage(""
                +itens.get(0).getCodigo()
                +" | "
                +itens.get(0).getNome()
                +" cadastrado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
        
        produto = new Produto();
        
    }
    
    public List<Produto> getItens() {
        return itens;
    }
    
    public void rmvProduto(Produto p){
        itens.remove(p);
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }
}
