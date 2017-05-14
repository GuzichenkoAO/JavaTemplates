package com.guzichenko.templates.jpa;

import com.guzichenko.templates.jpa.entities.Contact;
import com.guzichenko.templates.jpa.services.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author - Guzichenko Artem.
 */
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring.xml");

        Service service = context.getBean(Service.class);

      // Next work through Service
    }
}
