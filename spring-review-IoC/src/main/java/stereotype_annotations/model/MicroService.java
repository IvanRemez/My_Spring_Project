package stereotype_annotations.model;

import org.springframework.stereotype.Component;

@Component
public class MicroService extends Model{

    @Override
    public void getTotalHours() {
        System.out.println("Micro Services total hours: " + 20);
    }
}
