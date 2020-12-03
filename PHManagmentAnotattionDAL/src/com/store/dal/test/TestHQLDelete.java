
package com.store.dal.test;

import com.store.dal.manager.HibernateDBManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class TestHQLDelete {
   public static void main(String[] args) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            Query q = session.createQuery("delete from Drugs where name=:i");
            q.setParameter("i", "papa");

            int status = q.executeUpdate();
            System.out.println(status);
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(TestHQLUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
