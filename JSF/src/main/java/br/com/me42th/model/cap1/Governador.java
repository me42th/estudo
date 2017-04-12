/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model.cap1;

import java.io.Serializable;
import java.util.Scanner;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author david
 */
//@Entity
public class Governador implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToOne(cascade=CascadeType.ALL)
    private Estado estado;
    public static Governador getGovernador(){
        Governador retorno = new Governador();
        System.out.print("[Gov-NOME]\t");
        retorno.nome = new Scanner(System.in).findInLine(".*");
        retorno.estado = Estado.getEstado();
        return retorno;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
