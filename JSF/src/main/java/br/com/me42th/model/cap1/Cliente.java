/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model.cap1;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author david
 */
//@Entity
public class Cliente implements Serializable{

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;    
private String nome,cpf;
private Endereco endereco;


public static Cliente getCliente(){
    Cliente retorno = new Cliente();
    
    System.out.print("[Cliente-NOME]\t");
    retorno.nome = new Scanner(System.in).findInLine(".*");
    
    System.out.print("[Cliente-CPF]\t");
    retorno.cpf = new Scanner(System.in).findInLine(".*");
    
    retorno.endereco = Endereco.getEndereco();
    
    return retorno;
}
}
