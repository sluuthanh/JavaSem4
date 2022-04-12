/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import vn.aptech.entity.Account;

/**
 *
 * @author Administrator
 */
public class AccountDal {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccountPU");

    public void create(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public boolean checkLogin(String u, String p) {
        boolean result = false;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT o FROM Account o WHERE o.username=:u AND o.password=:p");
            q.setParameter("u", u);
            q.setParameter("p", p);
            result = q.getSingleResult() != null;
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
    
    public List<Account> findAll() {
        List<Account> result = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT o FROM Account o");
            result.addAll(q.getResultList());
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
    
    public Account findById(int id) {
        Account result = null;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            result = em.find(Account.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
    
    
}
