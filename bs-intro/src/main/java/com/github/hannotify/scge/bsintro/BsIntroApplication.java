package com.github.hannotify.scge.bsintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BsIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsIntroApplication.class, args);
	}

}
