/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.dao;

import br.com.me42th.hibernate.model.Palestra;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PalestraDAO {

private static EntityManager getEM(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("fuck");
    return emf.createEntityManager();
}

public static Palestra save(Palestra palestra){
    EntityManager em = getEM();
    try{
        em.getTransaction().begin();
        em.persist(palestra);
        em.getTransaction().commit();
    }catch(Exception ex){
        ex.printStackTrace();
        em.getTransaction().rollback();
    }finally{
        em.close();
    }
    return palestra;
}

public static void remove(int id){
    EntityManager em = getEM();
    try{
        em.getTransaction().begin();
        em.remove(em.find(Palestra.class,id));
        em.getTransaction().commit();
    }catch(Exception ex){
        ex.printStackTrace();
        em.getTransaction().rollback();
    }finally{
        em.close();
    }

}

public static Palestra search(int id){
    EntityManager em = getEM();
    Palestra palestra = null;
    try{
        em.getTransaction().begin();
        palestra = em.find(Palestra.class, id);
    
    }catch(Exception ex){
        System.out.println(":'(");
        ex.printStackTrace();
    }finally{
        em.close();
    }
    
    return palestra;
}
}
