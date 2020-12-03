/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.LogManager;
import com.store.bll.transformers.AdminTransformer;
import com.store.common.beans.AdminBean;
import com.store.dal.entities.Admin;
import com.store.dal.entities.Screens;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.repos.AdminDAO;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author ahmed
 */
public class LogManagerImpl implements LogManager {

    AdminTransformer adminTransformer = new AdminTransformer();

    @Override
    public boolean login(AdminBean adminBean) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
           HibernateDBManager.beginTransaction();
            AdminDAO adminDAO = new AdminDAO();

            Admin find = adminDAO.find(adminTransformer.transformBeanToEntity(adminBean));
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
            if (find == null) {
                return false;
            } else {
                if (adminBean.getPassword().equals(find.getPassword()) ) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {

           ex.printStackTrace();  return false;
        }

    }

    @Override
    public boolean logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminBean find(AdminBean adminBean) {
         AdminBean x = null;
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
           HibernateDBManager.beginTransaction();
            AdminDAO adminDAO = new AdminDAO();

            Admin find = adminDAO.find(adminTransformer.transformBeanToEntity(adminBean));
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
            Set<Screens> screenses = find.getScreenses();for (Screens screense : screenses) {
                System.out.println(screense.getAdmin().getName() +"------"+screense.getPage()); 
           
            }
            if (find == null) {
                return null;
            } else {
//               x = new AdminBean();
//                x.setName(find.getName());
//                x.setPassword(find.getPassword());
//                x.setScreenses( find.getScreenses());
//                return x;
return  adminTransformer.transformEntityToBean(find);
                }
            }
         catch (Exception ex) {
ex.printStackTrace();
          return null;
        }
      //  return x;

    }

    

}
