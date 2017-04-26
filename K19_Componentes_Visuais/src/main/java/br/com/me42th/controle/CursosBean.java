/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.controle;

import br.com.me42th.model.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author david
 */
@ManagedBean(name="cursosBean")
@SessionScoped
public class CursosBean {
    private List<Curso> cursos = new ArrayList<>();
    private Curso cadastro = new Curso();
        
    public void adcionaCurso(){
        if(!cursos.contains(cadastro))
            cursos.add(cadastro);
        cadastro = new Curso();
        FacesMessage mensagem = new FacesMessage("Curso cadastrado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    
    public void removeCurso(Curso curso){
        cursos.remove(curso);
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Curso getCadastro() {
        return cadastro;
    }

    public void setCadastro(Curso cadastro) {
        this.cadastro = cadastro;
    }
}
