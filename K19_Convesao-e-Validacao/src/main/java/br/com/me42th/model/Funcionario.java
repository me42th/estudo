/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.model;

import java.util.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
public class Funcionario {
    @NotNull(message="O campo salario eh obrigatorio")
    @Min(value = 0,message = "Informe um salario valido")
    
    private Double salario;
    @NotNull(message="Informe um COD valido")
    @Min(value = 5, message = "Informe um valor superior a 5 para COD")
    @Max(value = 19, message = "Informe um valor abaixo de 19 para COD")
    private int cod ;
    @NotNull(message="Informe uma data de nascimento valida")
       
    private Date aniversario;
    @NotNull(message="O campo nome eh obrigatorio")
    @Size(min=10,max=50,message="Informe um nome valido")
    @Pattern(regexp = "[A-Z][a-z]+( [A-Z][a-z]+)+",message="Informe o nome completo e apenas letras")
    private String nome;
    @NotNull(message="O campo sexo eh obrigatorio")
    private char sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }
}
