package com.store.bll.impl;

import com.store.bll.managers.DiscountManager;
import com.store.bll.transformers.DrugsTransformer;
import com.store.common.beans.DrugsBean;
import com.store.dal.entities.Drugs;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.repos.DrugsDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class DiscountManagerImpl implements DiscountManager {

    @Override
    public List<DrugsBean> listAllDiscount() {
        List<DrugsBean> l = null;
        try {

            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            DrugsDAO drugsDAO = new DrugsDAO();
            DrugsTransformer adminTransformer = new DrugsTransformer();
            List<Drugs> list = drugsDAO.findList();

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
            if (list != null) {
                l = new ArrayList<>();
                for (Drugs d : list) {

                    l.add(adminTransformer.transformEntityToBean(d));
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return l;
    }

    @Override
    public List<DrugsBean> findByNameDiscount(String name) {
        List<DrugsBean> find = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            DrugsDAO dAO = new DrugsDAO();

            DrugsTransformer drugsTransformer = new DrugsTransformer();
            List<Drugs> findList = dAO.findByName(name);
            if (findList != null) {
                find = new ArrayList();
                for (Drugs drugs : findList) {

                    find.add(drugsTransformer.transformEntityToBean(drugs));
                }
            }

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public List<DrugsBean> findByTypeDiscount(String type) {
        List<DrugsBean> find = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            DrugsDAO dAO = new DrugsDAO();

            DrugsTransformer drugsTransformer = new DrugsTransformer();
            List<Drugs> findList = dAO.findByType(type);
            if (findList != null) {
                find = new ArrayList();
                for (Drugs drugs : findList) {

                    find.add(drugsTransformer.transformEntityToBean(drugs));
                }
            }

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public List<DrugsBean> findByDiscount(int from, int to) {
        List<DrugsBean> find = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            DrugsDAO dAO = new DrugsDAO();

            DrugsTransformer drugsTransformer = new DrugsTransformer();
            List<Drugs> findList = dAO.findByDiscount(from, to);
            if (findList != null) {
                find = new ArrayList();
                for (Drugs drugs : findList) {
                    System.out.println(drugs.getName());
                    find.add(drugsTransformer.transformEntityToBean(drugs));
                }
            }

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public List<DrugsBean> findByPriceDiscount(int from, int to) {
        List<DrugsBean> find = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            DrugsDAO dAO = new DrugsDAO();

            DrugsTransformer drugsTransformer = new DrugsTransformer();
            List<Drugs> findList = dAO.findByPrice(from, to);
            if (findList != null) {
                find = new ArrayList();
                for (Drugs drugs : findList) {
                    System.out.println(drugs.getName());
                    find.add(drugsTransformer.transformEntityToBean(drugs));
                }
            }

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public DrugsBean updateDiscount(String name , int value) {
         Drugs find = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            DrugsDAO dAO = new DrugsDAO();

            DrugsTransformer drugsTransformer = new DrugsTransformer();
             Drugs findById = dAO.findById(name);
             findById.setDiscount(value);
            find = dAO.update(findById);

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
            return drugsTransformer.transformEntityToBean(find);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    }

