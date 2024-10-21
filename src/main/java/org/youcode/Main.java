package org.youcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.youcode.competition.Competition;
import org.youcode.competition.CompetitionService;
import org.youcode.competition.interfaces.CompetitionServiceI;
import org.youcode.config.ServiceConfig;
import org.youcode.cyclist.Cyclist;
import org.youcode.cyclist.CyclistDao;
import org.youcode.cyclist.CyclistService;
import org.youcode.cyclist.interfaces.CyclistDaoI;
import org.youcode.cyclist.interfaces.CyclistServiceI;
import org.youcode.stage.Stage;
import org.youcode.stage.StageService;
import org.youcode.stage.interfaces.StageServiceI;
import org.youcode.team.Team;

import java.time.LocalDate;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        childContext.setParent(xmlContext);
        childContext.register(ServiceConfig.class);
        childContext.refresh();
        try{
            CompetitionServiceI competitionService = (CompetitionService) childContext.getBean("competitionService");
            StageServiceI stageService =(StageService) childContext.getBean("stageService");
            Competition c = new Competition();
            c.setName("TDF");
            c.setStartDate(LocalDate.of(2024,6,3));
            c.setEndDate(LocalDate.of(2024,6,6));
            c.setYear(2024);
            c.setNumberOfStages(3);

            for (int i = 0 ; i < c.getNumberOfStages() ; i++){
                Stage s = new Stage();
                s.setNumber(i+1);
                s.setStartLocation("LYON");
                s.setEndLocation("MARSEILLE");
                s.setType("Time_Trial");
                s.setCompetition(c);

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }





    }
}