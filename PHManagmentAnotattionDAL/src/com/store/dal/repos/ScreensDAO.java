/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.Screens;
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
public class ScreensDAO implements  commonDAO<Screens>{
      @Override
      public Screens add(Screens screens) {
            HibernateDBManager.getSession().persist(screens);
            return screens;

      }

      @Override
      public Screens update(Screens screens) {
            HibernateDBManager.getSession().update(screens);
            return   screens;

      }

      @Override
      public void remove(Object seq) {
            HibernateDBManager.getSession().delete(seq);

      }

      @Override
      public Screens findById(Object seq) {
            return HibernateDBManager.getSession().get(Screens.class, (int)seq);

      }

      public List<Screens> findList() {
            Session session = HibernateDBManager.getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Screens> CriteriaQuery = builder.createQuery(Screens.class);
            Root<Screens> from0 = CriteriaQuery.from(Screens.class);
            CriteriaQuery.select(from0);
            Query<Screens> query = session.createQuery(CriteriaQuery);
            return query.getResultList();
      }

    
      public void patchRemove(List<Screens> screenses) {
            if (screenses == null) {

                  return;
            }
            for (Screens screens : screenses) {
                  remove(screens.getSeq());
            }

      }
}
