/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.me42th.dao.cap1;

import br.com.me42th.model.cap1.Departamento;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author david
 */
public class DepartamentoDAO {
    private static EntityManager getEM(){
    return Persistence.createEntityManagerFactory("livraria").createEntityManager();
    }
    public static Departamento save(Departamento dept){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(dept);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return dept;
    }
    
    public static Departamento search(int id){
        Departamento retorno = null;
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            retorno= em.find(Departamento.class,id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return retorno;
    }
}
