package com.oxsys.topcon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TopconApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(TopconApplication.class, args);
	}
}
