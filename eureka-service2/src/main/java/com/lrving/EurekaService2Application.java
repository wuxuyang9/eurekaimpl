package com.lrving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaService2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaService2Application.class, args);
	}

}
