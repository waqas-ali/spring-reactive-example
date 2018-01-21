package com.baeldung.reactive.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.baeldung.reactive.controller" })
public class SpringReactiveExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveExampleApplication.class, args);
	}
}
