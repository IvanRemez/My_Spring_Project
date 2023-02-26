package stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import stereotype_annotations.model.DataStructure;

@ComponentScan(basePackages = "stereotype_annotations")
public class AppConfig {

}
