package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.CourseConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.ExtraHours;
import stereotype_annotations.model.MicroService;

public class Main {

    public static void main(String[] args) {

        ApplicationContext container =
                new AnnotationConfigApplicationContext(CourseConfig.class);

        container.getBean(DataStructure.class).getTotalHours();

        container.getBean(MicroService.class).getTotalHours();

        System.out.println(container.getBean(ExtraHours.class).getHours());
    }
}
