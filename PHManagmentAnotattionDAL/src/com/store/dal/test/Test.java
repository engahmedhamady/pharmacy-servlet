/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.test;

import com.store.dal.entities.Admin;
import com.store.dal.entities.Drugs;
import com.store.dal.manager.HibernateDBManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Sroor For Laptop
 */
public class Test {

    public static void main(String[] args) {
        List<Admin> list = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
//            Query q = session.createQuery("from Drugs name" );
//            List<Drugs> list1 = q.list();
//            for (Drugs object : list1) {
//                System.out.println(object.getName());
//            }
       
         
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
