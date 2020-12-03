package com.store.dal.test;

import com.store.dal.entities.Drugs;
import com.store.dal.manager.HibernateDBManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class TestCreateUpdateQuery {

    public static void main(String[] args) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaUpdate<Drugs> criteriaUpdate = builder.createCriteriaUpdate(Drugs.class);
            Root<Drugs> from0 = criteriaUpdate.from(Drugs.class);
            criteriaUpdate.set("company", "tata");
            criteriaUpdate.where(builder.equal(from0.get("name"), "ahmoos"));
            int executeUpdate = session.createQuery(criteriaUpdate).executeUpdate();
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(TestHQLUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
