/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.test;

import com.store.dal.entities.Drugs;
import com.store.dal.manager.HibernateDBManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Sroor For Laptop
 */
public class TestCreateCriteriaQuery {
    public static void main(String[] args) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
          CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.multiselect(from0.get("name"),from0.get("company"));
       CriteriaQuery. where(builder.equal(from0.get("name"), "ahmoos"));
       
        org.hibernate.query.Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
              List<Drugs> resultList = adminQuery.getResultList();
        HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
            for (Drugs drugs : resultList) {
                  System.out.println(drugs.getName());
                   System.out.println(drugs.getCompany());
            }
          
        } catch (Exception ex) {
            Logger.getLogger(TestHQLUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
