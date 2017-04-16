/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th;

import java.util.Objects;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author david
 */
@ManagedBean(name="curso")
public class Curso {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.cod);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        return true;
    }
    
    private String nome;
    private String cod;

    public Curso() {
    }

    public Curso(String nome, String cod) {
        this.nome = nome;
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
}
