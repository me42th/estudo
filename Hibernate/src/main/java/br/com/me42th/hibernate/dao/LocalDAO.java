/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.dao;

import br.com.me42th.hibernate.model.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author david
 */
public class LocalDAO {
    private static EntityManager getEM(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuck");
    return emf.createEntityManager();
    }
    
    public static Local save(Local local){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(local);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
     return local;
    }
    
    public static Local search(int id){
        EntityManager em = getEM();
        Local resultado = null;
        try{
            em.getTransaction().begin();
            resultado = em.find(Local.class,id);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }finally{
            em.close();
        }
        return resultado;
    }
}
