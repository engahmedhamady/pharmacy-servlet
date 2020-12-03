package com.store.dal.test;

import com.store.dal.entities.Admin;
import com.store.dal.entities.Drugs;
import com.store.dal.manager.HibernateDBManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class TestHQLSelect {

    public static void main(String[] args) {
        List<Admin> list = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            //Query query = session.createQuery(" from Drugs where Name  =:n ");
            //Query query = session.createQuery(" from Drugs where Name  ='mama' ");
            //Query query = session.createQuery(" from Drugs u where u.name=:n");
            //query.setParameter("n", "mama");

            // List list1 = query.list();
//            for (Object object : list1) {
//                Drugs d = (Drugs) object;
//                System.out.println(d.getName());
//                System.out.println(d.getBarcode());
//            }
        //    Query query = session.createQuery("select name FROM Drugs ");
         //   List list1 = query.list();        
          //  System.out.println(list1);
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
