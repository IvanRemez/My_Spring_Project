package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class NewAppConfig {

    @Bean(name = "welcome")
    public String str1() {
        return "Welcome to CydeoApp";
    }

    @Bean(name = "str2")
    public String str2() {
        return "Spring Core Practice";
    }
}
