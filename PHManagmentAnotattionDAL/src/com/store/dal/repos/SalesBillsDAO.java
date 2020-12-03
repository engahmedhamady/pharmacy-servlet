/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.SalesBills;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.ArrayList;
import java.util.Date;
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
public class SalesBillsDAO implements commonDAO<SalesBills> {

    @Override
    public SalesBills add(SalesBills salesBills) {
        HibernateDBManager.getSession().persist(salesBills);
        return salesBills;

    }

    @Override
    public SalesBills update(SalesBills salesBills) {
        HibernateDBManager.getSession().update(salesBills);
        return salesBills;

    }

    @Override
    public void remove(Object billCode) {
        HibernateDBManager.getSession().delete(billCode);

    }

    @Override
    public SalesBills findById(Object billCode) {
        return HibernateDBManager.getSession().get(SalesBills.class, (int) billCode);

    }

    @Override
    public List<SalesBills> findList() {
        Session session = HibernateDBManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SalesBills> CriteriaQuery = builder.createQuery(SalesBills.class);
        Root<SalesBills> from0 = CriteriaQuery.from(SalesBills.class);
        CriteriaQuery.select(from0);
        Query<SalesBills> query = session.createQuery(CriteriaQuery);
        return query.getResultList();
    }

    public void patchRemove(List<SalesBills> salesBillses) {
        if (salesBillses == null) {

            return;
        }
        for (SalesBills salesBills : salesBillses) {
            remove(salesBills.getBillCode());
        }

    }

    public List<SalesBills> findByTotal(int from, int to) {
        List<SalesBills> salesBillses = null;
        Session session = HibernateDBManager.getSession();
        String querySql = "SELECT * FROM sales_bills where totalnet between ? and ?";
        Query query = session.createNativeQuery(querySql)
                .addScalar("Bill_Code")
                .addScalar("Bill_Date")
                .addScalar("Totalnet")
                .addScalar("totalProfits");
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();

        if (list.size() > 0) {
            salesBillses = new ArrayList<>();
            for (Object[] p : list) {
                SalesBills d = new SalesBills();
                d.setBillCode((int) p[0]);
                d.setBillDate((Date) p[1]);
                d.setTotalnet((Integer) p[2]);
                d.setTotalProfits((Integer) p[3]);
                salesBillses.add(d);

            }
            return salesBillses;
        } else {
            return null;
        }
    }

    public List<SalesBills> findByDate(Date from, Date to) {
        List<SalesBills> salesBillses = null;
        Session session = HibernateDBManager.getSession();
        System.out.println("sssssssssssssssss");
        String querySql = "SELECT * FROM sales_bills where Bill_Date between ? and ?";
         System.out.println("qqqqqqqqqqqqqqqqqqqq");
        Query query = session.createNativeQuery(querySql)
                .addScalar("Bill_Code")
                .addScalar("Bill_Date")
                .addScalar("Totalnet")
                .addScalar("totalProfits");
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();
         System.out.println("LLLLLLLLLLLLLLLLL");
        System.out.println(list);
        if (list.size() > 0) {
            salesBillses = new ArrayList<>();
            for (Object[] p : list) {
                SalesBills d = new SalesBills();
                d.setBillCode((int) p[0]);
                d.setBillDate((Date) p[1]);
                d.setTotalnet((Integer) p[2]);
                d.setTotalProfits((Integer) p[3]);
                salesBillses.add(d);

            }
             System.out.println("1111111111111");
            System.out.println(salesBillses);
           
            return salesBillses;
        } else {
            
            return null;
        }
    }

    public List<SalesBills> findByProfit(int from, int to) {
        List<SalesBills> salesBillses = null;
        Session session = HibernateDBManager.getSession();
        String querySql = "SELECT * FROM sales_bills where totalprofits between ? and ?";
        Query query = session.createNativeQuery(querySql)
                .addScalar("Bill_Code")
                .addScalar("Bill_Date")
                .addScalar("Totalnet")
                .addScalar("totalProfits");
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();

        if (list.size() > 0) {
            salesBillses = new ArrayList<>();
            for (Object[] p : list) {
                SalesBills d = new SalesBills();
                d.setBillCode((int) p[0]);
                d.setBillDate((Date) p[1]);
                d.setTotalnet((Integer) p[2]);
                d.setTotalProfits((Integer) p[3]);
                salesBillses.add(d);

            }
            return salesBillses;
        } else {
            return null;
        }

    }
}
