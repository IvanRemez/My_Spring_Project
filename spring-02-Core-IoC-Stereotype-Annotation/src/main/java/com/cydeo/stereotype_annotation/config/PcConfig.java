package com.cydeo.stereotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cydeo") // << specifies which folders to scan
                // ^^ can also just pass ("com.cydeo") directly
public class PcConfig {


}
