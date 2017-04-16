/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author david
 */
@ManagedBean(name="chuck")
public class Johnny {
    
    private final static List<Curso> lista;
    static{
            lista = new ArrayList<>();
            lista.add(new Curso("Java","1"));
            lista.add(new Curso(".net","2"));
            lista.add(new Curso("Delphi","3"));
            lista.add(new Curso("MySQL","4"));
            lista.add(new Curso("Structs","5"));
            lista.add(new Curso("Hibernate","6"));
    }
   
    private final String userF = "me42th",senhaF = "qwerty";
    private List<String> cursosEscolhidos;

    public List<Curso> getLista(){
        return lista;
    }

    public List<String> getCursosEscolhidos() {
        return cursosEscolhidos;
    }
    
    public String next(){
        return "next";
    }
    
    public String escolhas(){
        String retorno = "Cursos: ";
        for(String temp : cursosEscolhidos)
            retorno += temp;
        return retorno;
    }
    
    public void setCursosEscolhidos(List<String> cursosEscolhidos) {
        this.cursosEscolhidos = cursosEscolhidos;
    }

    
    
    private String nome = "David Meth", 
                   sexo = "M",
                   nasc = "13/12/1990",
                   user, senha;
    
    public String login(){
    if(user.equalsIgnoreCase(userF) && senha.equals(senhaF))
        return "login";
    return "index";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
