/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author david
 */
//@Entity
public class Fatura implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy="fatura", cascade=CascadeType.PERSIST)
    private List<Ligacao> ligacoes;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimento = new Date((int)(Math.random()*1999900000));
    @Transient
    private int valor = 3;
    public static Fatura getFatura(){
        Fatura retorno = new Fatura();
        retorno.ligacoes = new ArrayList<>();
        while(true){
            Ligacao tempLig = Ligacao.getLigacao();
            if(tempLig.getDuracao() == 0) break;
            retorno.ligacoes.add(tempLig);
        }
        return retorno;
    }
    
    public int getValor(){
        int cont = 0;
            for(Ligacao l : ligacoes)
                cont += l.getDuracao() * valor;
        return cont;    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ligacao> getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(List<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    
}
