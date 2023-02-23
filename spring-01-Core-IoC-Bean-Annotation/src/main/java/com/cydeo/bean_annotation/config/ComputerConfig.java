package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {

    @Bean
    public Monitor monitorSony() {    // Polymorphism: Monitor abc = new SonyMonitor()
        return new SonyMonitor("25 inch Beast", "Sony", 25);
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
