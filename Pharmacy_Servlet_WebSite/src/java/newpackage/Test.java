/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import com.store.bll.delegate.StoreGetWay;
import com.store.bll.transformers.AdminTransformer;
import com.store.common.beans.AdminBean;
import com.store.common.beans.LostDrugsBean;
import com.store.dal.entities.Admin;
import com.store.dal.entities.Screens;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.repos.AdminDAO;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Sroor For Laptop
 */
public class Test {

    public static void main(String[] args) {
        //  try {
        AdminBean bean = new AdminBean();
        bean.setName("admin");
        bean.setPassword("admin");
        StoreGetWay getWay = new StoreGetWay();
        List< LostDrugsBean> selectAll = getWay.listAllRequested();

        for (LostDrugsBean lostDrugsBean : selectAll) {
            System.out.println(lostDrugsBean.getDrugname() + "  "
                    + lostDrugsBean.getDrugtype() + "  " + lostDrugsBean.getQuantitydrug()
            );

        }

    }
}
