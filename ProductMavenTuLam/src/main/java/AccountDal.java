
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import vn.aptech.entity.Account;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class AccountDal {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("vn.aptech_ProductMavenTuLam_war_1.0PU");

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
    
     public List<Account> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Account> result = new ArrayList<>();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT o FROM Account o");
            em.getTransaction().commit();
            result.addAll(q.getResultList());
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
    
    public Account findById(int id) {
        EntityManager em = emf.createEntityManager();
        Account result = null;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT o FROM Account o WHERE o.id=:id");
            em.getTransaction().commit();
            q.setParameter("id", id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
    
    public boolean checkLogin(String u, String p) {
        EntityManager em = emf.createEntityManager();
        boolean result = false;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT o FROM Account o WHERE o.username:u o.password=:p");
            em.getTransaction().commit();
            q.setParameter("u", u);
            q.setParameter("p", p);
            result = q.getSingleResult() != null;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
}
