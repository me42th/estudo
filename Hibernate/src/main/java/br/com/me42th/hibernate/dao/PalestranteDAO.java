/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.dao;

import br.com.me42th.hibernate.model.Palestrante;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PalestranteDAO {
    private static EntityManager getEM(){
        return Persistence.createEntityManagerFactory("fuck").createEntityManager();
    }
    public static Palestrante save(Palestrante palestrante){
    
        EntityManager em = getEM();
   
        try{  
            em.getTransaction().begin();
            em.persist(palestrante);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(":O \n\n"+ex.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
    }
    return palestrante;
    }
    
    public static Palestrante search(int id){
        EntityManager em = getEM();
        Palestrante palestrante = null;
        try{
             palestrante = em.find(Palestrante.class, id);
        }catch(Exception ex){
             ex.printStackTrace();
        }
        finally{
             em.close(); 
        }
        return palestrante;
    }
}
