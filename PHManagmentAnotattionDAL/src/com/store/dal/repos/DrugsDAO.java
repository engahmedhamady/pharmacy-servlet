/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.Drugs;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import org.hibernate.SQLQuery;
import org.hibernate.query.Query;

import org.hibernate.Session;

/**
 *
 * @author ahmed
 */
public class DrugsDAO implements commonDAO<Drugs> {

    @Override
    public Drugs add(Drugs drugs) {
        HibernateDBManager.getSession().save(drugs);
        return drugs;

    }

    @Override
    public Drugs update(Drugs drugs) {
        HibernateDBManager.getSession().update(drugs);
        return drugs;

    }

    @Override
    public void remove(Object billCode) {
        HibernateDBManager.getSession().delete(billCode);

    }

    public List<Drugs> findList() {
        Session session = HibernateDBManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0);
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();
    }

    public List<Drugs> findByName(String name) {
        Session session = HibernateDBManager.getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("name"), name));
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }

    public List<Drugs> findByType(String type) {
        Session session = HibernateDBManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("type"), type));
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }

    public List<Drugs> findByCompanye(String type) {
        Session session = HibernateDBManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("company"), type));
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }

    public List<Drugs> findByPrice(int from, int to) {
        List<Drugs> drugses = null;
        Session session = HibernateDBManager.getSession();
        String querySql = "SELECT * FROM Drugs where 	Selling_price between ? and ?";
        Query query = session.createNativeQuery(querySql);
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();
   
           if (list.size()>0) {
               drugses = new ArrayList<>();
             for (Object[] p : list) {
                Drugs d = new Drugs();
                d.setBarcode((String) p[0]);
                d.setName((String) p[1]);
                d.setType((String) p[2]);
                d.setPurchasingPrice((int) p[3]);
                d.setSellingPrice((int) p[4]);
                d.setDiscount((int) p[5]);
                d.setQuantity((int) p[6]);
                d.setProfit((int) p[7]);
                d.setCompany((String) p[8]);
                drugses.add(d);
                
            }
        }
        return drugses;
    }
//public List<Drugs> findByExpiry(Date from , Date to) {
//        List<Drugs> list=new ArrayList<>();
//         Session session = HibernateDBManager.getSession();
//        String hql = " select * from Drugs where Name=? ";
//        Query query = session.createNativeQuery(hql).addEntity(Drugs.class);
//        query.setParameter("Name", "");
//         List <Object[]>result = query.list();
//         for (Object[] objects : result) {
//            list.add((Drugs) objects[0]);
//        }
//        return list;
//
//    }

    public List<Drugs> findByQuantity(int from, int to) {
        List<Drugs> drugses = null;
        Session session = HibernateDBManager.getSession();
        String querySql = "SELECT * FROM Drugs where 	quantity between ? and ?";
        Query query = session.createNativeQuery(querySql);
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();
   
           if (list.size()>0) {
               drugses = new ArrayList<>();
             for (Object[] p : list) {
                Drugs d = new Drugs();
                d.setBarcode((String) p[0]);
                d.setName((String) p[1]);
                d.setType((String) p[2]);
                d.setPurchasingPrice((int) p[3]);
                d.setSellingPrice((int) p[4]);
                d.setDiscount((int) p[5]);
                d.setQuantity((int) p[6]);
                d.setProfit((int) p[7]);
                d.setCompany((String) p[8]);
                drugses.add(d);
                
            }
        }
        return drugses;

    }

    @Override
    public Drugs findById(Object id) {
        return HibernateDBManager.getSession().find(Drugs.class, (String) id);
    }

    public List<Drugs> findByDiscount(int from, int to) {
 List<Drugs> drugses = null;
        Session session = HibernateDBManager.getSession();
        String querySql = "SELECT * FROM Drugs where 	discount between ? and ?";
        Query query = session.createNativeQuery(querySql);
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();
   
           if (list.size()>0) {
               drugses = new ArrayList<>();
             for (Object[] p : list) {
                Drugs d = new Drugs();
                d.setBarcode((String) p[0]);
                d.setName((String) p[1]);
                d.setType((String) p[2]);
                d.setPurchasingPrice((int) p[3]);
                d.setSellingPrice((int) p[4]);
                d.setDiscount((int) p[5]);
                d.setQuantity((int) p[6]);
                d.setProfit((int) p[7]);
                d.setCompany((String) p[8]);
                drugses.add(d);
                
            }
        }
        return drugses;
    }

}
