package org.youcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.youcode.cyclist.Cyclist;
import org.youcode.cyclist.CyclistDao;
import org.youcode.cyclist.interfaces.CyclistDaoI;
import org.youcode.team.Team;
import org.youcode.utils.DataSourceSyncHandler;
import org.youcode.utils.HibernateUtil;


public class Main {
    public static void main(String[] args) {
        DataSourceSyncHandler.syncDataSource();
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CyclistDaoI cyclistDao = (CyclistDao) appContext.getBean("cyclistDao");

        Team t = new Team();
        t.setId(1L);
        t.setName("sky");

        Cyclist c = new Cyclist();
        c.setFirstName("tadej");
        c.setLastName("pocadscar");
        c.setAge(21);
        c.setNationality("slovenian");
        c.setTeam(t);

        try {
            cyclistDao.save(c);
            System.out.println("cyclist" + c.getFirstName() + " " + c.getLastName() + "created successfully !");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        HibernateUtil.shutdown();
    }
}