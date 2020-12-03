/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.SettingManager;
import com.store.bll.transformers.AdminTransformer;
import com.store.common.beans.AdminBean;
import com.store.dal.entities.Admin;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.repos.AdminDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Sroor For Laptop
 */
public class SettingManagerImpl implements SettingManager {

    AdminTransformer adminTransformer = new AdminTransformer();

    @Override
    public void addAccount(AdminBean adminBean) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            AdminDAO adminDAO = new AdminDAO();

            adminDAO.add(adminTransformer.transformBeanToEntity(adminBean));
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(LogManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteAccount(AdminBean adminBean) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            AdminDAO adminDAO = new AdminDAO();

            adminDAO.remove(adminTransformer.transformBeanToEntity(adminBean));
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(LogManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePassword(AdminBean adminBean) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            AdminDAO adminDAO = new AdminDAO();

            adminDAO.update(adminTransformer.transformBeanToEntity(adminBean));
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(LogManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<AdminBean> listAll() {
        List<AdminBean> l = null;
        try {

            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            AdminDAO adminDAO = new AdminDAO();
            AdminTransformer adminTransformer = new AdminTransformer();
            List<Admin> list = adminDAO.findList();

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
            if (list!=null){
                 l= new ArrayList<>();
            for (Admin admin : list) {
              
              l.add(adminTransformer.transformEntityToBean(admin));  
            }
            
            }
            
        } catch (Exception ex) {
            Logger.getLogger(LogManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

}
