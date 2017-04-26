/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author david
 */
public class Produto {
    private String precoF;

    public String getPrecoF() {
        return precoF;
    }

    public void setPrecoF(String precoF) {
        this.precoF = precoF;
    }
    private Double preco;
    private String nome;
    private String img;
    public final static List<Produto> ESTOQUE = new ArrayList<>();
    static {
        String [] inicioImg = new String[]
        {"chave de fenda (","enxada (","martelo ("};  
        String [] itemNome = new String[]
        {"Chave de fenda","Enxada","Martelo"}; 
        String [] itemDesc = new String[]
        {" da paz"," da calmaria"," do tormento eterno"," de Melchor"," from hell"," from heaven"};
        for(int j = 0; j < 3;j++)  
          for(int i = 1 ; i<=6;i++)
                ESTOQUE.add(
                        new Produto(
                          itemNome[j]+itemDesc[i-1],
                          "/img/"+inicioImg[j]+i+").jpg",
                          Math.random()*100
                        )
                );      
    }
    
    public Produto(String nome, String img, Double preco){
        this.nome = nome;
        this.preco = preco;
        this.precoF = new DecimalFormat("R$ 0.##").format(preco);
        this.img = img;
    }
    
    public Produto(){
    
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
