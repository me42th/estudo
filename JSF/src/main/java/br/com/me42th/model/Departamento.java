/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author david
 */
//@Entity
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany(cascade=CascadeType.ALL)
    
    private List<Funcionario> funcionarios;

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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public static Departamento getDepartamento(){
        Departamento retorno = new Departamento();
        retorno.funcionarios = new ArrayList<>();
        System.out.print("[Dept-NOME]\t");
        retorno.nome = new Scanner(System.in).findInLine(".*");
        while(true){
            Funcionario tempFunc = Funcionario.getFuncionario();
            if(tempFunc.getNome().equalsIgnoreCase("exit")) break;
            retorno.funcionarios.add(tempFunc);
        }
        
        return retorno;
    }
}
