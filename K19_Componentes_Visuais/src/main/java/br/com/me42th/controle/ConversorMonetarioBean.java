/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controle;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="conversor")
public class ConversorMonetarioBean {
    
    private String de, para;
    private Double valor;
    private Map<String,Double> taxas;
    
    public ConversorMonetarioBean(){
        taxas = new LinkedHashMap<>();
        taxas.put("Real",1.0);
        taxas.put("Euro",2.33);
        taxas.put("Peso argentino",0.42);
        taxas.put("Dolar Americano",1.84);
        
    }
    
    
    
    public String conversao(){
        
        if(de == null || para == null)
            return "";
        return new DecimalFormat("0.##")
                .format(
                        (valor*taxas.get(de))/taxas.get(para)
                );
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Map<String, Double> getTaxas() {
        return taxas;
    }

    public void setTaxas(Map<String, Double> taxas) {
        this.taxas = taxas;
    }
}
