package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataStructure extends Model{

    private final ExtraHours extraHours;

    @Override
    public void getTotalHours() {
        System.out.println("Data Structure total hours: " + (35 + extraHours.getHours()));
    }
}
