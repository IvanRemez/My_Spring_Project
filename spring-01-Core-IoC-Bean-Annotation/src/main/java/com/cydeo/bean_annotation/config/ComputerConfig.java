package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {

    @Bean(name = "sony")
    public Monitor monitorSony() {    // Polymorphism: Monitor abc = new SonyMonitor()
        return new SonyMonitor("25 inch Beast", "Sony", 25);
    }

    @Primary
    @Bean
    public Monitor monitorAcer(){
        return new AcerMonitor("23 inch Beast","Acer",23);
    }

    @Bean
    public Case caseDell() {    // Polymorphism: Case abc = new DellCase()
        return new DellCase("220B", "Dell", "240");
    }

    @Bean
    public Motherboard motherboardAsus() {    // Polymorphism: Motherboard abc = new AsusMotherboard()
        return new AsusMotherboard("BJ-200", "Asus", 4, 4, "v2.44");
    }

}
