package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = AopAutoConfiguration.class)
public class CydeoApp {

	public static void main(String[] args) {
		SpringApplication.run(CydeoApp.class, args);
	}

}
