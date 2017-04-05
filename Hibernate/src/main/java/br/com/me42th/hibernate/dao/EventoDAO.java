/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.hibernate.dao;

import br.com.me42th.hibernate.model.Evento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author david
 */
public class EventoDAO {
   private static EntityManager getEM(){
       return Persistence.createEntityManagerFactory("fuck").createEntityManager();
   } 
   
   public static Evento save(Evento evento){
       EntityManager em = getEM();
       try{
           em.getTransaction().begin();
           em.persist(evento);
           em.getTransaction().commit();
       }catch(Exception ex){
           ex.printStackTrace();
           em.getTransaction().rollback();
       }finally{
           em.close();
       }
       return evento;
   }
   public static List<Evento> consultarTodos(){
        EntityManager em = getEM();
        Query queri;
        try{
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{}
        return null;
   }
}
