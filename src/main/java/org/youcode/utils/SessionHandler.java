package org.youcode.utils;

import org.hibernate.Session;

public class SessionHandler {
    private static final ThreadLocal<Session> threadLocalSession = new ThreadLocal<>();

    public static void openSession(){
        Session s = HibernateUtil.getSession();
        threadLocalSession.set(s);
    }

    public static Session getCurrentSession (){
        return threadLocalSession.get();
    }

    public static void closeSession(){
        Session s = getCurrentSession();
        if (s != null){
            s.close();
            threadLocalSession.remove();
        }
    }

}
