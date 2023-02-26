package stereotype_annotations.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class ExtraHours {

    public Integer getHours() {
        return 10;
    }
}
