package com.api.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { JsonProperties.class })
public class TccApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TccApplication.class);
		app.addInitializers(new JsonPropertyContextInitializer());
		app.run(args);
	}
}
