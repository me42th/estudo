/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;


public class RCI {
private String p1,p2,p3;
private boolean isIt;

    @Override
    public boolean equals(Object obj) {
        try{
            return ((RCI)obj).p1.equals(this.p1);
        }catch(Exception ex){
            return false;
        }        
    }
 
    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public RCI() {
    }

    public RCI(String p1, String p2,String p3,Boolean isIt) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.isIt = isIt;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public boolean isIsIt() {
        return isIt;
    }

    public void setIsIt(boolean isIt) {
        this.isIt = isIt;
    }

    @Override
    public String toString() {
        String retorno = isIt
                ?p1+"-"+p2+p3
                :p1+p2+p3; 
        return retorno;
    }
    
}
