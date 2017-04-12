/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.dao;

import br.com.me42th.model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author david
 */
public class ClienteDAO {
    private static EntityManager getEM(){
        return Persistence
                .createEntityManagerFactory("livraria")
                .createEntityManager();
    }
    public static Cliente save(Cliente c){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
        return c;
    }
    
    public static Cliente search(int i){
        EntityManager em = getEM();
        Cliente retorno = null;
        try{
            em.getTransaction().begin();
            retorno = em.find(Cliente.class,i);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return retorno;
    }
    
}
