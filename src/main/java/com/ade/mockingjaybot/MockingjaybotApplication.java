package com.ade.mockingjaybot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MockingjaybotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockingjaybotApplication.class, args);
	}

}
