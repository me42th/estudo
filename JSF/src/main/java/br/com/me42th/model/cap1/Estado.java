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
public class Estado implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToOne(mappedBy="estado")
    private Governador governador;

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

    public Governador getGovernador() {
        return governador;
    }

    public void setGovernador(Governador governador) {
        this.governador = governador;
    }
    
    public static Estado getEstado(Governador g){
        Estado retorno = new Estado();
        System.out.print("[Est-NOME]\t");
        retorno.nome = new Scanner(System.in).findInLine(".*");
        retorno.governador = g;
        return retorno;
    }
    public static Estado getEstado(){
        Estado retorno = new Estado();
        System.out.print("[Est-NOME]\t");
        retorno.nome = new Scanner(System.in).findInLine(".*");
        return retorno;
    }
}
