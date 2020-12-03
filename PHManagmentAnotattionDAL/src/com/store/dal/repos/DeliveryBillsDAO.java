/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.DeliveryBills;
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
public class DeliveryBillsDAO implements commonDAO<DeliveryBills> {

      @Override
      public DeliveryBills add(DeliveryBills deliveryBills) {
            HibernateDBManager.getSession().persist(deliveryBills);
            return deliveryBills;

      }

      @Override
      public DeliveryBills update(DeliveryBills deliveryBills) {
            HibernateDBManager.getSession().update(deliveryBills);
            return deliveryBills;

      }
  @Override
      public void remove(Object billCode) {
            HibernateDBManager.getSession().delete(billCode);

      }

      @Override
      public DeliveryBills findById(Object billCode) {
            return HibernateDBManager.getSession().get(DeliveryBills.class,(int)billCode);

      }

      @Override
      public List<DeliveryBills> findList() {
            Session session = HibernateDBManager.getSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<DeliveryBills> CriteriaQuery = builder.createQuery(DeliveryBills.class);
            Root<DeliveryBills> from0 = CriteriaQuery.from(DeliveryBills.class);
            CriteriaQuery.select(from0);
            Query<DeliveryBills> adminQuery = session.createQuery(CriteriaQuery);
            return adminQuery.getResultList();
      }

      public void patchRemove(List<DeliveryBills> deliveryBillses) {
            if (deliveryBillses == null) {

                  return;
            }
            for (DeliveryBills deliveryBills : deliveryBillses) {
                  remove(deliveryBills.getBillCode());
            }

      }
}
