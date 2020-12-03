/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.Customer;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;

/**
 *
 * @author ahmed
 */
public class CustomerDAO  implements  commonDAO<Customer> {
  @Override
      public Customer add(Customer customer) {
            HibernateDBManager.getSession().save(customer);
            return customer;

      }
  @Override
      public Customer update(Customer customer) {
            HibernateDBManager.getSession().update(customer);
            return customer;

      }

  @Override
      public void remove(Object name) {
            HibernateDBManager.getSession().delete(name);

      }
  @Override
      public Customer findById(Object ID) {
            return HibernateDBManager.getSession().get(Customer.class, (int)ID);

      }

  @Override
      public List<Customer> findList() {
            Session session = HibernateDBManager.getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> CriteriaQuery = builder.createQuery(Customer.class);
            Root<Customer> from0 = CriteriaQuery.from(Customer.class);
            CriteriaQuery.select(from0);
            Query<Customer> adminQuery = session.createQuery(CriteriaQuery);
            return adminQuery.getResultList();
      }

      public void patchRemove(List<Customer> customers) {
            if (customers == null) {

                  return;
            }
            for (Customer customer : customers) {
                  remove(customer.getName());
            }

      }
      public List<Customer> findByName(String name) {
        Session session = HibernateDBManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> CriteriaQuery = builder.createQuery(Customer.class);
        Root<Customer> from0 = CriteriaQuery.from(Customer.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("name"), name));
        org.hibernate.query.Query<Customer> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }
}
