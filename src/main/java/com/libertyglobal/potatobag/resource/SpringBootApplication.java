package com.libertyglobal.potatobag.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan({"com.libertyglobal.potatobag.service",
"com.libertyglobal.potatobag.model","com.libertyglobal.potatobag.resource"})
public class SpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);	
	}
}
