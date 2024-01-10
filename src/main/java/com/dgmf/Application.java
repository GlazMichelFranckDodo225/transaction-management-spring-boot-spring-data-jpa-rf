package com.dgmf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableTransactionManagement ==> Enable by Default by Spring Boot once
// @Transactional Annotation has been added on the top of any Method
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
