/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.io.Serializable;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author david
 */
//@Entity
public class Ligacao implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    Fatura fatura;
    private int duracao;
    public static Ligacao getLigacao(){
        Ligacao retorno = new Ligacao();
        
        while(true)
            try{
                System.out.print("[Lig-DURACAO]\t");
                retorno.duracao = Integer.parseInt(new Scanner(System.in).findInLine(".*"));
                break;
            }
            catch(Exception ex){
                System.out.println("[VALOR_INVALIDO]");
            }
        return retorno;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
    
}
