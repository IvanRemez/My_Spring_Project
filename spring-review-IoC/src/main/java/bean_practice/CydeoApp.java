package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(NewAppConfig.class, AppConfig.class);

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();

        PartTimeEmployee pt = container.getBean(PartTimeEmployee.class);
        pt.createAccount();

        String str1 = container.getBean("welcome", String.class);
        System.out.println("str1 = " + str1);

        String str2 = container.getBean("str2", String.class);
        System.out.println("str2 = " + str2);
    }
}
