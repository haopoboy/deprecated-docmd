package com.github.haopoboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DocmdProperties.class)
public class DocmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocmdApplication.class, args);
	}
}