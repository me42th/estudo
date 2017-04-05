/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.dao;

import br.com.me42th.model.Editora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author david
 */
public class EditoraDAO {
    private static EntityManager getEM(){
        return Persistence.createEntityManagerFactory("livraria").createEntityManager();
    }
    
    public static Editora save(Editora editora){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(editora);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return editora;
    }
    
    public static Editora search(int id){
       return getEM().find(Editora.class, id);
    }
    
    public static Editora search(String atributo){
        Query query = getEM().createQuery("Select e from Editora e");
        for(Editora e: ((List<Editora>)query.getResultList()))
            if(e.getNome().contains(atributo)) return e;
        return null;
    }
    
    public static void remove(Editora editora){
       EntityManager em = getEM();
       em.getTransaction().begin();
       em.remove(editora);
       em.getTransaction().commit();
       em.close();
    }
    
   public static void update(){
       EntityManager em = getEM();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
   }
}
