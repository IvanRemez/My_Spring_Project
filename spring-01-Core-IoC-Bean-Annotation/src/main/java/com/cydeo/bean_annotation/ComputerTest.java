package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {

// Creating container using BeanFactory:

        BeanFactory context =
                new AnnotationConfigApplicationContext();

// Creating container using Application Context:

        ApplicationContext container =
                new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);
//                                            ^^ this constructor is accepting Class so -> .class^^

// Retrieving the Beans:

        SonyMonitor sony = container.getBean(SonyMonitor.class);
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);
//      ^^ Specified Objects from container

        PC newPC = new PC(dell, sony, asus);

        newPC.powerUp();
        dell.pressPowerButton();

        System.out.println("-----------------------------------------------");
/*
        Monitor theMonitor = container.getBean(Monitor.class);
        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);
        ^^ Generic Objects from container
 */
// Multiple Objects:

//        Monitor theMonitor1 = container.getBean("monitorSony", Monitor.class);
//                                                  ^^ DEFAULT BEAN NAME

        Monitor theMonitor2 = container.getBean("sony", Monitor.class);
//                                                  ^^ CUSTOM BEAN NAME
//                                                  ^^ set in Config class, next to @Bean
        System.out.println(theMonitor2);

        Monitor theMonitor3 = container.getBean(Monitor.class);
        System.out.println(theMonitor3);    // ^^ no specification = prints @Primary
    }
}
