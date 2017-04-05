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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author david
 */
@NamedQueries(
    @NamedQuery(name = "Evento.consultarTodos",
                query = "Select e FROM Evento e"
    )
)
@Entity
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String organizacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fim;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="evento_id")
    private List<Palestra> palestras;

    public String getOrganizacao() {
        return organizacao;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nome=" + nome + ", organizacao=" + organizacao + ", inicio=" + inicio + ", fim=" + fim + ", palestras=" + palestras + '}';
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public int getId() {
        return id;
    }

    public List<Palestra> getPalestras() {
        return palestras;
    }

    public void setPalestras(List<Palestra> palestra) {
        this.palestras = palestra;
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

    public String getOrganizazao() {
        return organizacao;
    }

    public void setOrganizazao(String organizacao) {
        this.organizacao = organizacao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
