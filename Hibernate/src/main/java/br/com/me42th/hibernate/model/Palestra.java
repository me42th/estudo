/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author david
 */
@Entity
public class Palestra implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="titulo")
    private String titulo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_hora")
    private Date dataHora; 
    @Column(name="Duracao")
    private int duracao;
    @ManyToOne
    private Evento evento;

    public Palestra(int id) {
        this.id = id;
    }

    public Palestra() {
    }
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Palestrante> getPalestrantes() {
        return palestrantes;
    }

    public void setPalestrantes(List<Palestrante> palestrantes) {
        this.palestrantes = palestrantes;
    }
    @OneToOne(cascade = CascadeType.ALL)
    private Local local;
    @ManyToMany//(cascade = CascadeType.ALL, mappedBy="palestra")
    @JoinTable( 
            name = "palestra_palestrante", 
            joinColumns = @JoinColumn(name = "palestra_id"),
            inverseJoinColumns = @JoinColumn(name="palestrante_id")
    )
    private List<Palestrante> palestrantes;
    
    @Override
    public String toString() {
        return "Palestra{" + "id=" + id + ", titulo=" + titulo + ", dataHora=" + dataHora + ", duracao=" + duracao + ", local=" + local + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    
}
