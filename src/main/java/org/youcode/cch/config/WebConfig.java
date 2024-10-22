package org.youcode.cch.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AnnotationConfigWebApplicationContext childContext = new AnnotationConfigWebApplicationContext();
        childContext.register(ServiceConfig.class);
        childContext.register(MvcConfig.class);
        childContext.setParent(xmlContext);
        childContext.setServletContext(servletContext);
        childContext.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(childContext);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("app", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/*");
        System.out.println("DONE !!!!");
    }
}
