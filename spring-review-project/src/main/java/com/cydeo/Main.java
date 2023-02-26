package com.cydeo;

import com.cydeo.config.AppConfig;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext container =
                new AnnotationConfigApplicationContext(AppConfig.class);

        container.getBean(SalaryService.class).calculateRegularSalary();

    }
}
