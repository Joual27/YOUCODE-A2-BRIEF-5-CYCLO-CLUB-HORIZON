package org.youcode.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataSourceSyncHandler {

    public static void syncDataSource(){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.close();
            System.out.println("Database schema updated!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
