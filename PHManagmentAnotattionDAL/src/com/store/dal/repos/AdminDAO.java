/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.Admin;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ahmed
 */
public class AdminDAO  implements  commonDAO<Admin> {
// insert 
      @Override
      public Admin add(Admin admin) {
            HibernateDBManager.getSession().persist(admin);
            return admin;

      }

      @Override
      public Admin update(Admin admin) {
            HibernateDBManager.getSession().update(admin);
            return admin;

      }
// delete
      @Override
      public void remove(Object name) {
            HibernateDBManager.getSession().delete(name);

      }
// find by name
      @Override
      public Admin findById(Object name) {
            return HibernateDBManager.getSession().get(Admin.class, (String)name);

      }
      public Admin find(Admin admin) {
       return HibernateDBManager.getSession().find(Admin.class,  admin.getName());

      }

      @Override
      public List<Admin> findList() {
            Session session = HibernateDBManager.getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> adminCriteriaQuery = builder.createQuery(Admin.class);
            Root<Admin> from0 = adminCriteriaQuery.from(Admin.class);
            adminCriteriaQuery.select(from0);
            Query<Admin> adminQuery = session.createQuery(adminCriteriaQuery);
            return adminQuery.getResultList();
      }
         public void patchRemove(List <Admin>admins) {
                if (admins==null) {
                     
                        return;
                     }
                for (Admin admin : admins) {
                       remove(admin.getName());
               }
             

      }
//           public int  patchUpdate(List <Admin>admins) {
//                  Session session = HibernateDBManager.getSession();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaUpdate<Admin> adminCriteriaUpdate = builder.createCriteriaUpdate(Admin.class);
//            Root<Admin> from0 = adminCriteriaUpdate.from(Admin.class);
//            adminCriteriaUpdate.where(builder.)
//             
//
//      }
}
