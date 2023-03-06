package com.mahmoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ConfigurationProperties("com.mahmoud.config")
@EnableJpaRepositories("com.mahmoud.repository")
@EnableSwagger2
public class AppointmentManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppointmentManagementSystemApplication.class, args);
	}



}
