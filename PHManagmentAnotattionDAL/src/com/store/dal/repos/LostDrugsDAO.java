/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;


import com.store.dal.entities.LostDrugs;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ahmed
 */
public class LostDrugsDAO implements commonDAO<LostDrugs> {

      @Override
      public LostDrugs add(LostDrugs lostDrugs) {
            HibernateDBManager.getSession().save(lostDrugs);
            return lostDrugs;

      }

      @Override
      public LostDrugs update(LostDrugs lostDrugs) {
            HibernateDBManager.getSession().update(lostDrugs);
            return lostDrugs;

      }

      @Override
      public void remove(Object name) {
            HibernateDBManager.getSession().delete(name);
            
      }

      @Override
      public LostDrugs findById(Object name) {
            return HibernateDBManager.getSession().get(LostDrugs.class, (String) name);

      }

      @Override
      public List<LostDrugs> findList() {
            Session session = HibernateDBManager.getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<LostDrugs> CriteriaQuery = builder.createQuery(LostDrugs.class);
            Root<LostDrugs> from0 = CriteriaQuery.from(LostDrugs.class);
            CriteriaQuery.select(from0);
            Query<LostDrugs> query = session.createQuery(CriteriaQuery);
            return query.getResultList();
      }

      public void patchRemove(List<LostDrugs> lostDrugses) {
            if (lostDrugses == null) {

                  return;
            }
            for (LostDrugs lostDrugs : lostDrugses) {
                  remove(lostDrugs.getDrugName());
            }

      }
       public List<LostDrugs> findByName(String name) {
        Session session = HibernateDBManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LostDrugs> CriteriaQuery = builder.createQuery(LostDrugs.class);
        Root<LostDrugs> from0 = CriteriaQuery.from(LostDrugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("drugName"), name));
        org.hibernate.query.Query<LostDrugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }
 public List<LostDrugs> findByType(String type) {
        Session session = HibernateDBManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LostDrugs> CriteriaQuery = builder.createQuery(LostDrugs.class);
        Root<LostDrugs> from0 = CriteriaQuery.from(LostDrugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("drugType"), type));
        org.hibernate.query.Query<LostDrugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();


    }
}
