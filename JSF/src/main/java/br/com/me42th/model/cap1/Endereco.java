/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model.cap1;

import java.io.Serializable;
import java.util.Scanner;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable{
private String pais;
private String estado;
private String cidade;
private String logradouro;
private String numero;
private String complemento;
private String cep;

    public Endereco() {

    }

    public static Endereco getEndereco(){
    Endereco retorno = new Endereco();    
    
    System.out.print("[End-PAIS]\t");
    retorno.pais = new Scanner(System.in).findInLine(".*");
    
    System.out.print("[End-ESTADO]\t");
    retorno.estado = new Scanner(System.in).findInLine(".*");

    System.out.print("[End-CIDADE]\t");
    retorno.cidade = new Scanner(System.in).findInLine(".*");

    System.out.print("[End-RUA]\t");
    retorno.logradouro = new Scanner(System.in).findInLine(".*");

    System.out.print("[End-NUMERO]\t");
    retorno.pais = new Scanner(System.in).findInLine(".*");

    System.out.print("[End-COMPL]\t");
    retorno.complemento = new Scanner(System.in).findInLine(".*");

    System.out.print("[End-CEP]\t");
    retorno.cep = new Scanner(System.in).findInLine(".*");
    
    return retorno;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    
}
