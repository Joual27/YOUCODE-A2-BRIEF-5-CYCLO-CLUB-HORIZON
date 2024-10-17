package org.youcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.youcode.config.ServiceConfig;
import org.youcode.cyclist.Cyclist;
import org.youcode.cyclist.CyclistDao;
import org.youcode.cyclist.CyclistService;
import org.youcode.cyclist.interfaces.CyclistDaoI;
import org.youcode.cyclist.interfaces.CyclistServiceI;
import org.youcode.team.Team;


public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        childContext.setParent(xmlContext);
        childContext.register(ServiceConfig.class);
        childContext.refresh();

        CyclistServiceI cyclistService = (CyclistService) childContext.getBean("cyclistService");
        Team t = new Team();
        t.setId(2L);
        t.setName("jumbo-visma");

        Cyclist c = new Cyclist();
        c.setFirstName("jonas");
        c.setLastName("vindergaard");
        c.setAge(22);
        c.setNationality("Danish");
        c.setTeam(t);

        try {
            cyclistService.save(c);
            System.out.println("cyclist" + c.getFirstName() + " " + c.getLastName() + "created successfully !");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}