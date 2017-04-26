/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.dao;

import br.com.me42th.model.Estado;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author david
 */
public class EstadoDAO {

    private static EntityManager getEM(){
        return Persistence
                .createEntityManagerFactory("livraria")
                .createEntityManager();
    }
    public static Estado save(Estado e){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return e;
    }
}
