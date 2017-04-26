/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.util.Objects;

/**
 *
 * @author david
 */
public class CPF {
    
    private String id;
    private char d1,d2;

    public CPF(String id, char d1, char d2) {
        this.id = id;
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final CPF other = (CPF) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+"-"+d1+""+d2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getD1() {
        return d1;
    }

    public void setD1(char d1) {
        this.d1 = d1;
    }

    public char getD2() {
        return d2;
    }

    public void setD2(char d2) {
        this.d2 = d2;
    }
          
}
